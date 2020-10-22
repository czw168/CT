package cn.ubot.test;

import org.junit.Test;

public class StringTest {
	
	@Test
	public void lastIndexOf() {
		String str = "daads,dasdasdas,fdasdasd,adasda";
		int lastIndexOf = str.lastIndexOf(",");
		System.out.println(lastIndexOf);
		
		System.out.println(str.substring(str.lastIndexOf(",") + 1));
		
	}

}
