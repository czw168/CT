package cn.ubot;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class TestRemoteConnect {
	public static void main(String[] args) {
		String path = "/mnt/8TB/DATA/KEYENCE/CA-H1DB/192.168.0.10/VisionDB/CV-X470A_00_01_FC_27_03_6F/SD1/007/Image/20200705_063635";
		String hostName = "192.168.4.70";
		int port = 22;
		String username = "root";
		String password = "5E@G@7e512";
		Connection ss = getConnect(hostName, username, password, port);
		if (fileExist(path, ss)) {
			readLogFile(path, ss);
		}
	}

	public static Connection getConnect(String hostName, String username, String password, int port) {
		Connection conn = new Connection(hostName, port);
		try {
			// 连接到主机
			conn.connect();
			// 使用用户名和密码校验
			boolean isconn = conn.authenticateWithPassword(username, password);
			if (!isconn) {
				System.out.println("用户名称或者是密码不正确");
			} else {
				System.out.println("服务器连接成功.");
				return conn;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean fileExist(String path, Connection conn) {
		if (conn != null) {
			Session ss = null;
			try {
				ss = conn.openSession();
				ss.execCommand("ls -l ".concat(path));
				InputStream is = new StreamGobbler(ss.getStdout());
				BufferedReader brs = new BufferedReader(new InputStreamReader(is));
				String line = "";
				while (true) {
					String lineInfo = brs.readLine();
					;
					if (lineInfo != null) {
						line = line + lineInfo;
					} else {
						break;
					}
				}
				System.out.println(line);
				System.out.println(line.length());
				//System.out.println(line.startsWith("-"));
				brs.close();
				if (line != null && line.length() > 0) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 连接的Session和Connection对象都需要关闭
				if (ss != null) {
					ss.close();
				}
			}
		}
		return false;
	}

	public static void readLogFile(String path, Connection conn) {
		if (conn != null) {
			Session ss = null;
			try {
				ss = conn.openSession();
				ss.execCommand("tail -100 ".concat(path));
				InputStream is = new StreamGobbler(ss.getStdout());
				BufferedReader brs = new BufferedReader(new InputStreamReader(is));
				while (true) {
					String line = brs.readLine();
					if (line == null) {
						break;
					} else {
						System.out.println(line);
					}
				}
				brs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 连接的Session和Connection对象都需要关闭
				if (ss != null) {
					ss.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
		}
	}
}
