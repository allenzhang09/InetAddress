import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class URLDemo {
	
	public static void main(String[] args)	{
		
		try {
			URL tirc = new URL("http://www.cs.tsinghua.edu.cn/");
			BufferedReader in = new BufferedReader(new InputStreamReader(tirc.openStream())) ;
			String inputLine;
			while ((inputLine = in.readLine())!=null) {
				System.out.println(inputLine);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
