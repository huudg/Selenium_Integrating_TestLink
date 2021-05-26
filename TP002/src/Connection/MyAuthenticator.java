package Connection;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;

public class MyAuthenticator extends Authenticator{
	/*final PasswordAuthentication authentication;
	
    public MyAuthenticator(String userName, String password) {
         authentication = new PasswordAuthentication(userName, password.toCharArray());
    }*/
 // This method is called when a password-protected URL is accessed
    protected PasswordAuthentication getPasswordAuthentication() {
        // Get information about the request
        String promptString = getRequestingPrompt();
        String hostname = getRequestingHost();
        InetAddress ipaddr = getRequestingSite();
        int port = getRequestingPort();
        System.out.print(promptString);
        System.out.print(hostname);
        System.out.print(ipaddr);
        System.out.print(port);
        // Get the username from the user...
        String username = "admin";
 
        // Get the password from the user...
        String password = "admin";
 
        // Return the information
        return new PasswordAuthentication(username, password.toCharArray());
    }
}
