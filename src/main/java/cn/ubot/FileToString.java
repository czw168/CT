package cn.ubot;

import java.io.*;

public class FileToString {
	public static String readFile(String fileName) {
		String output = "";
		File file = new File(fileName);
		if (file.exists()) {
			if (file.isFile()) {
				try {
					BufferedReader input = new BufferedReader(new FileReader(file));
					StringBuffer buffer = new StringBuffer();
					String text;
					while ((text = input.readLine()) != null)
						buffer.append(text + "/n");
					output = buffer.toString();
				} catch (IOException ioException) {
					System.err.println("File Error!");
				}
			} else if (file.isDirectory()) {
				String[] dir = file.list();
				output += "Directory contents:/n";
				for (int i = 0; i < dir.length; i++) {
					output += dir[i] + "/n";
				}
			}
		} else {
			System.err.println("Does not exist!");
		}
		return output;
	}

	public static void main(String args[]) {
		String path = "/mnt/8TB/DATA/KEYENCE/CA-H1DB/192.168.0.10/VisionDB/CV-X470A_00_01_FC_27_03_6F/SD1/007/Image/20200705_063635";
		String hostName = "192.168.4.70";
		int port = 22;
		String username = "root";
		String password = "5E@G@7e512";
		TestRemoteConnect.getConnect(hostName, username, password, port);
		String str = readFile("/mnt/8TB/DATA/KEYENCE/CA-H1DB/192.168.0.10/VisionDB/CV-X470A_00_01_FC_27_03_6F/SD1/007/Image/20200705_063635/20200705_063955_0000108000_&Cam1Img.Bmp");
		System.out.print(str);
	}
}
