package testcases;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSetup2 {
	public static void main(String[] args) throws EmailException 
	{
		System.out.println("==================Test Started-=====================");
		
		
		Email email=new SimpleEmail();
		
		email.setHostName("smtp.gmail.com");
		
		//decimal port number 25 hai//
		email.setSmtpPort(465);
		
		email.setAuthenticator(new DefaultAuthenticator("rohitkr7may@gmail.com", "Rohit#116"));
		
		email.setSSLOnConnect(false);
		
		email.setFrom("rohitkumarmay2@gmail.com");
		
		email.setSubject("SeleniumTestReport ");
		
		email.setMsg("THis is a test mail Massage");
		
		email.addTo("rohitkr7may@outlook.com");
		email.send();

		System.out.println("=================Test Email has been sent====================");

	}

}
