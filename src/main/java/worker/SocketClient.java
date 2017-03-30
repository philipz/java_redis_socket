package worker;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClient {
	static String address = "10.121.11.179";// 連線的ip
	static int port = 7000;// 連線的port

	public static void main(String[] args) {
		SocketClient sc = new SocketClient();
		String data = sc.callRemote(address, "020000Y ");
		System.out.println("我取得的值:" + data);
	}

	public String callRemote(String IP, String input) {
		Socket socket = null;
		String data = "";
		try {
			socket = new Socket(IP, port);
			BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
			BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());

			out.write("020000Y ".getBytes());
			out.flush();
			byte[] b = new byte[1024];

			int length;
			if ((length = in.read(b)) > 0)// <=0的話就是結束了
			{
				data += new String(b, 0, length);
			}
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}