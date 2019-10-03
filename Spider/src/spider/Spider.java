package spider;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.*;



public class Spider {
	//保存文件的路径。
	private static String savefile = "E:\\test4.txt";
	//获取url的地址 进行资源获取。
	public static String getmessage(String url)  {
			URL url1;
			StringBuilder mes = new StringBuilder();
			  
			try {
				url1 = new URL(url);
				InputStream is = url1.openStream();
				//以UTF-8的形式获取内容
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				String msg = null;
				while(null!=(msg = br.readLine())) {
					mes.append(msg);		
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//返回该url的网页源码的内容。
			return mes.toString();
			}
		
	public static void main(String[] args) throws Exception {
			String message = getmessage("https://www.w3.org/Consortium/Member/List");
			//System.out.println(message);
			//输入正则表达式，以获取对应的memberlist的内容。
			Pattern p = Pattern.compile("class=\"member\">(\\D.+?)</a>");
			Matcher m = p.matcher(message);
			FileWriter fwriter = null;
			fwriter = new FileWriter(savefile);
			while(m.find()) {
				 //用捕获组1 写入文件中。
			     fwriter.write(m.group(1));
			     fwriter.append("\r\n");
				
			}
			//推送文件流。
			fwriter.flush();
			//关闭文件流。
			fwriter.close();
			
			
			
			
		}
}
