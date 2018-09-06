package email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import base.testBase;

public class sendEmailReport extends testBase  {

    public static Session session;
    public static Message message;

    public static void sendEmailReportTo(){
        //give your email id
        final String username = "@gmail.com";
        //enter your password
        final String password = "*********";
        //receivers email address
        final String receiverEmailID = "@gmail.com";
        //CC
        final String receiverEmailCC = "@gmail.com";
        //BCC
        final String receiverEmailBCC = "@gmail.com";
        //Subject line
        final String subjectLine = "Automation Test Report (open in GoogleChrome)";
        //body
        final String bodyMessage = "HI, \n"+
                " Please find the Attachment. \n"+
                " Please go through the file Automationresult.html  \n"+
                "\n"+
                "\n"+
                " Thanks and Regards, \n"+
                " Divij.";


        // Create object of Property file
        prop = new Properties();

        // this will set host of server- you can change based on your requirement
        prop.put("mail.smtp.host", "smtp.gmail.com");

        // set the port of socket factory
        prop.put("mail.smtp.socketFactory.port", "465");

        // set socket factory
        prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

        // set the authentication to true
        prop.put("mail.smtp.auth", "true");

        // set the port of SMTP server
        prop.put("mail.smtp.port", "465");

        // This will handle the complete authentication
        session = Session.getDefaultInstance(prop,

                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(username, password);

                    }

                });

        try {

            // Create object of MimeMessage class
            message = new MimeMessage(session);

            // Set the from address
            message.setFrom(new InternetAddress(username));

            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receiverEmailID));

            //CC
            message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(receiverEmailCC));

            //BCC
            message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse(receiverEmailBCC));

            // Add the subject link
            message.setSubject(subjectLine);

            // Create object to add multimedia type content
            BodyPart messageBodyPart1 = new MimeBodyPart();

            // Set the body of email
            messageBodyPart1.setText(bodyMessage);

            // Create another object to add another content
            //MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            // Mention the file which you want to send
            //String file = "G:\\a.xlsx";
            String file = "C:\\Users\\Divij\\workspace\\sers\\test-output\\emailable-report.html";
            String filename = "TestReport.html";
            String file2 ="C:\\Users\\Divij\\workspace\\sers\\test-output\\Default suite\\Default test.html";
            String filename2 = "Defaulttestreport.html";
            String file3 = "C:\\Users\\Divij\\workspace\\sers\\test-output\\index.html";
            String filename3 = "testNGindexReport.html";
            String file4 = "C:\\Users\\Divij\\workspace\\sers\\test-output\\AutomationResult.html";
            String filename4 = "AutomationResult.html";
            // Create data source and pass the filename
					/*DataSource source = new FileDataSource(file);
		            DataSource source2 = new FileDataSource(file2);
		           // DataSource source3 = new FileDataSource(file3);

					// set the handler
					messageBodyPart2.setDataHandler(new DataHandler(source));
					messageBodyPart2.setDataHandler(new DataHandler(source2));
					//messageBodyPart2.setDataHandler(new DataHandler(source3));

					// set the file
					messageBodyPart2.setFileName(filename);
					messageBodyPart2.setFileName(filename2);
					//messageBodyPart2.setFileName(filename3);
*/
            // Create object of MimeMultipart class
            Multipart multipart = new MimeMultipart();

            // add body part 1
            //	multipart.addBodyPart(messageBodyPart2);
            addAttachment(multipart, file, filename);
            addAttachment(multipart, file2, filename2);
            addAttachment(multipart, file3, filename3);
            addAttachment(multipart, file4, filename4);

            // add body part 2
            multipart.addBodyPart(messageBodyPart1);

            // set the content
            message.setContent(multipart);

            // finally send the email
            Transport.send(message);

            System.out.println("===============Email Sent===============");

        } catch (MessagingException e) {

            throw new RuntimeException(e);

        }

    }

    private static void addAttachment(Multipart multipart, String File, String filename) throws MessagingException
    {
        DataSource source = new FileDataSource(File);
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);
    }

}
