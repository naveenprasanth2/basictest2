package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mysql.cj.xdevapi.Session;

public class ExcelRetest {

	public static void main(String[] args) throws IOException {
		    Properties props = System.getProperties();
		    props.setProperty("mail.store.protocol", "imap");
		    props.setProperty("mail.imap.ssl.enable", "true");
		    props.setProperty("mail.imaps.partialfetch", "false");
		    props.put("mail.mime.base64.ignoreerrors", "true");

		    Session mailSession = Session.getInstance(props);
		    mailSession.setDebug(true);
		    Store store = mailSession.getStore("imap");
		    store.connect("outlook.office365.com", "YOUREMAILADDRESS", "YOUR PASSWORD");


		    Folder folder = store.getFolder("INBOX");
		    folder.open(Folder.READ_ONLY);

		    System.out.println("Total Message:" + folder.getMessageCount());
		    System.out.println("Unread Message:" + folder.getUnreadMessageCount());

		    messages = folder.getMessages();

		    for (Message mail : messages) {         



		            System.out.println("*********************************");
		            System.out.println("MESSAGE : \n");

		            System.out.println("Subject: " + mail.getSubject());
		            System.out.println("From: " + mail.getFrom()[0]);
		            System.out.println("To: " + mail.getAllRecipients()[0]);
		            System.out.println("Date: " + mail.getReceivedDate());
		            System.out.println("Size: " + mail.getSize());
		            System.out.println("Flags: " + mail.getFlags());
		            System.out.println("ContentType: " + mail.getContentType());
		            System.out.println("Body: \n" + getEmailBody(mail));    
		            System.out.println("*******************************");          

		    }
		}

}
}