package eapli.base.collaborator.application;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * The type Email sender.
 */
class EmailSender {

    /**
     * Send email boolean.
     *
     * @param to       the to
     * @param subjectt the subjectt
     * @param contentt the contentt
     * @return the boolean
     */
    public static boolean sendEmail(String to, String subjectt, String contentt) {

        final String from = "lapr4.isep@gmail.com";

        //provide Mailtrap's username
        final String username = "ced4761822bc0e";

        //provide Mailtrap's password
        final String password = "c02f884022de13";

        //provide Mailtrap's host address
        //smtp.gmail.com
        final String host = "smtp.mailtrap.io";

        //configure Mailtrap's SMTP server details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        //create the Session object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            //create a MimeMessage object
            Message message = new MimeMessage(session);

            //set From email field
            message.setFrom(new InternetAddress(from));

            //set To email field
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            //set email subject field
            message.setSubject(subjectt);

            //set the content of the email message
            message.setContent(contentt, "text/html");

            //send the email message
            Transport.send(message);

            return true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Boolean sendPassword(String email, String password) {
        String invoice = "Your password Arrived";
        String message = "Hello, you're password is:\n" + password;

        return sendEmail(email, invoice, message);
    }
}
