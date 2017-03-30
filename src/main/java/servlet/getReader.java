package servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import worker.SocketClient;

public class getReader extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public getReader() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ip = request.getParameter("cardIP");
		String cmd = request.getParameter("cmd");
		//SocketClient sc = new SocketClient();
        //String result1 = sc.callRemote("127.0.0.1", cmd);
		Jedis redis = connectToRedis("192.168.2.11");
		String data = "{'r_IP': " + ip + ", 'cmd': " + cmd + "}";

		redis.rpush("votes", data);
		String result = "";
		while (true) {
			result = redis.blpop(0, "result").get(1);
			break;
		}
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("讀卡機回傳：" + result);
	}
	
	static Jedis connectToRedis(String host) {
		Jedis conn = new Jedis(host);

		while (true) {
			try {
				conn.keys("*");
				break;
			} catch (JedisConnectionException e) {
				System.err.println("Failed to connect to redis - retrying");
				sleep(1000);
			}
		}
		System.err.println("Connected to redis");
		return conn;
	}

	static void sleep(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			System.exit(1);
		}
	}
}
