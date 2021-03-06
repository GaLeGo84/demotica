/**
 * Classe responsavel pelo envio de mensagens de email
 * Aplicaçao da API mail.jar
 */

package demotica;

import java.security.Security;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final String SMTP_PORT = "465";
    private static final String EMAILFROMADDRESS = "dthj@gmail.com";
    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    /**
     * Metodo de envio de email
     * @param emailMsgTxt corpo da mensagem
     * @param emailSubjectTxt assunto da mensagem
     * @param sendTo email do destinatário
     * @throws Exception é uma exeção
     */
    public static void sendMail(String emailMsgTxt, String emailSubjectTxt, String sendTo) throws Exception {

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        new Email().sendSSLMessage(sendTo, emailSubjectTxt,
                emailMsgTxt, EMAILFROMADDRESS);
        
    }

    public void sendSSLMessage(String recipient, String subject,
            String message, String from) throws MessagingException {
        boolean debug = true;

        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("univent.uac", "uac14/15");
                    }
                });

        session.setDebug(debug);

        Message msg = new MimeMessage(session);
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress addressTo = new InternetAddress(recipient);

        msg.setRecipient(Message.RecipientType.TO, addressTo);

        msg.setSubject(subject);
        msg.setContent(message, "text/plain");
        Transport.send(msg);
    }
}
