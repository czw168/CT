package cn.ubot.common;

import java.io.UnsupportedEncodingException;

public class NumberParser {
	public String convertISO8859_1ToGBK(String str) {
		String returnStr = "";
		if (str.startsWith("\"")) {
			str = str.substring(1);
		}
		if (str.endsWith("\"")) {
			str = str.substring(0, str.length() - 1);
		}
		try {
			returnStr = new String(str.getBytes("ISO8859_1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return returnStr;
	}

	public static void main(String[] args) {
		try {
			String str = "中山廠區: 台中市潭子區中山路三段153號";
			String str1 = new String(str.getBytes("GBK"), "iso8859-1");
			System.out.println(str1);
			System.out.println(new String(str1.getBytes("iso8859-1"), "GBK"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private static final String[] SINGLE_NUM_ARR = { "", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT",
			"NINE" };
	private static final String[] TEN_NUM_ARR = { "TEN", "ELEVEN", "TWELEVE", "THIRTEEN", "FOURTEEN", "FIFTEEN",
			"SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN" };
	private static final String[] TEN_INTEGER_ARR = { "TEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY",
			"EIGHTY", "NINETY" };

	public static String parse(String x) {
		if (Double.parseDouble(x) <= 0.0D) {
			return "ZERO CENTS ONLY";
		}
		int z = x.indexOf(".");
		String lstr = "", rstr = "";
		if (z > -1) {
			lstr = x.substring(0, z);
			rstr = x.substring(z + 1);
		} else {
			lstr = x;
		}
		String lstrrev = reverse(lstr);
		String[] a = new String[5];
		switch (lstrrev.length() % 3) {
		case 1:
			lstrrev = lstrrev + "00";
			break;
		case 2:
			lstrrev = lstrrev + "0";
			break;
		}
		String lm = "";
		for (int i = 0; i < lstrrev.length() / 3; i++) {
			a[i] = reverse(lstrrev.substring(3 * i, 3 * i + 3));
			if (!a[i].equals("000")) {
				if (i != 0) {
					lm = transThree(a[i]) + " " + parseMore(String.valueOf(i)) + " " + lm;
				} else {
					lm = transThree(a[i]);
				}
			} else {
				lm = lm + transThree(a[i]);
			}
		}
		String xs = "";
		if (z > -1) {
			String transTwo = transTwo(rstr);
			if (transTwo == null || "".equals(transTwo)) {
				xs = "";
			} else {
				xs = "AND " + transTwo + " CENTS ";
			}
		}
		return lm.trim() + " " + xs + "ONLY";
	}

	private static String parseFirst(String s) {
		return SINGLE_NUM_ARR[Integer.parseInt(s.substring(s.length() - 1))];
	}

	private static String parseTeen(String s) {
		return TEN_NUM_ARR[Integer.parseInt(s) - 10];
	}

	private static String parseTen(String s) {
		return TEN_INTEGER_ARR[Integer.parseInt(s.substring(0, 1)) - 1];
	}

	private static String transTwo(String s) {
		String value = "";
		if (s.length() > 2) {
			s = s.substring(0, 2);
		} else if (s.length() < 2) {
			s = s + "0";
		}
		if (s.startsWith("0")) {
			value = parseFirst(s);
		} else if (s.startsWith("1")) {
			value = parseTeen(s);
		} else if (s.endsWith("0")) {
			value = parseTen(s);
		} else {
			value = parseTen(s) + " " + parseFirst(s);
		}
		return value;
	}

	private static String parseMore(String s) {
		String[] a = { "", "THOUSAND", "MILLION", "BILLION" };
		return a[Integer.parseInt(s)];
	}

	private static String transThree(String s) {
		String value = "";
		if (s.startsWith("0")) {
			value = transTwo(s.substring(1));
		} else if (s.substring(1).equals("00")) {
			value = parseFirst(s.substring(0, 1)) + " HUNDRED";
		} else {
			value = parseFirst(s.substring(0, 1)) + " HUNDRED AND " + transTwo(s.substring(1));
		}
		return value;
	}

	private static String reverse(String s) {
		char[] aChr = s.toCharArray();
		StringBuffer tmp = new StringBuffer();
		for (int i = aChr.length - 1; i >= 0; i--) {
			tmp.append(aChr[i]);
		}
		return tmp.toString();
	}
}
