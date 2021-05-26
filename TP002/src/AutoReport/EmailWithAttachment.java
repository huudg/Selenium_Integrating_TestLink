package AutoReport;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Connection.Constants;
import Connection.HTTPUtils;
import Connection.MyAuthenticator;
import Connection.getReport;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class EmailWithAttachment {
	//public static WebDriver driver;
	public static void main(String[] args) {
		 try {			 
			 /*
			 URL server = new URL("http://localhost/testlink_1_9_20/lib/results/printDocument.php?level=testproject&id=1407&type=testreport&docTestPlanId=1408&summary=y&passfail=y&step_exec_status=y&format=4"); //works for https and not for http, i needed https in  my case.
			 Authenticator.setDefault(new MyAuthenticator("admin", "admin"));

			 URLConnection connection = (URLConnection)server.openConnection();
			 connection.connect();
			 InputStream is = connection.getInputStream();
			 //System.out.println(connection.toString());
			 //System.out.println(is.available());

			 byte[] buffer = new byte[is.available()];
			    is.read(buffer);
			    
			    File targetFile = new File("D:\\Diep_Gia_Huu\\Java Source Code\\Selenium_Integrating_TestLink-main\\Selenium_Integrating_TestLink-main\\TP002\\src\\report\\TestReport1.doc");
			    OutputStream outStream = new FileOutputStream(targetFile);
			    outStream.write(buffer);
			
			  */
			/* 
			 try {
					String webPage = "\"http://localhost/testlink_1_9_20/lib/results/printDocument.php?level=testproject&id=1407&type=testreport&docTestPlanId=1408&summary=y&passfail=y&step_exec_status=y&format=4\"";
					String name = "admin";
					String password = "admin";

					String authString = name + ":" + password;
					System.out.println("auth string: " + authString);
					byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
					String authStringEnc = new String(authEncBytes);
					System.out.println("Base64 encoded auth string: " + authStringEnc);

					URL url = new URL(webPage);
					URLConnection urlConnection = url.openConnection();
					urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
					InputStream is = urlConnection.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);

					int numCharsRead;
					char[] charArray = new char[1024];
					StringBuffer sb = new StringBuffer();
					while ((numCharsRead = isr.read(charArray)) > 0) {
						sb.append(charArray, 0, numCharsRead);
					}
					String result = sb.toString();

					System.out.println("*** BEGIN ***");
					System.out.println(result);
					System.out.println("*** END ***");
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 
			 HTTPUtils.download("http://localhost/testlink_1_9_20/lib/results/printDocument.php?level=testproject&id=1407&type=testreport&docTestPlanId=1408&summary=y&passfail=y&step_exec_status=y&format=4", "D:\\Diep_Gia_Huu\\Java Source Code\\Selenium_Integrating_TestLink-main\\Selenium_Integrating_TestLink-main\\TP002\\src\\report\\TestReport2.doc");
			    */
			 File file = getReport.getLastModified("D:\\Diep_Gia_Huu\\Java Source Code\\Selenium_Integrating_TestLink-main\\Selenium_Integrating_TestLink-main\\TP002\\src\\report");
	           // Tạo một đối tượng đính kèm
			 System.out.println(file.getAbsolutePath());
	           EmailAttachment attachment = new EmailAttachment();
	           attachment.setPath(file.getAbsolutePath());
	           attachment.setDisposition(EmailAttachment.ATTACHMENT);
	           attachment.setDescription("Report");
	           attachment.setName("TestReport.html");
	 
	           // Tạo đối tượng Email
	           MultiPartEmail email = new MultiPartEmail();
	 
	           // Cấu hình
	           email.setHostName("smtp.googlemail.com");
	           email.setSmtpPort(465);
	           email.setSSLOnConnect(true);
	           email.setAuthenticator(new DefaultAuthenticator(Constants.MY_EMAIL, Constants.MY_PASSWORD));
	           email.setFrom(Constants.MY_EMAIL, "Huu");
	           email.addTo(Constants.FRIEND_EMAIL, "Leader");
	 
	           email.setSubject("TEST REPORT");
	           email.setMsg("Test report");
	 
	           // Thêm đính kèm
	           email.attach(attachment);
	 
	           // Gửi email
	           email.send();
	 
	           System.out.println("Sent!");
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	   }
}
