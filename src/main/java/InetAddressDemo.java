import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class InetAddressDemo {
	
	public static void main(String[] args)	{
		
	try {
		InetAddress inet1 = 
				InetAddress.getByName("www.163.com");
		System.out.println(inet1);
		
		InetAddress inet2 = 
				InetAddress.getByName("127.0.0.1");
		System.out.println(inet2);
		
		InetAddress inet3 = InetAddress.getLocalHost();
		System.out.println(inet3);
		String host = inet3.getHostName();
		String ip = inet3.getHostAddress();
		System.out.println(ip);
		
		Socket sock1 = new Socket("www.163.com", 80);
		OutputStream o1 = sock1.getOutputStream();
		InputStream i1 = sock1.getInputStream();
		
		o1.write("HTTP/GET".getBytes());
		System.out.println(i1);
		sock1.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
