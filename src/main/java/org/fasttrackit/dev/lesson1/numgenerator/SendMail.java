package org.fasttrackit.dev.lesson1.numgenerator;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by computer1977 on 8/22/2015.
 */
public class SendMail implements Runnable {
        private int nr;
        private int tentatives;
        private double time;
        private String toEmail;

    public SendMail( int nr, int tentatives, double time, String toEmail) {
        this.nr = nr;
        this.tentatives = tentatives;
        this.time = time;
        this.toEmail = toEmail;

    }

    public void send(){
        Thread t = new Thread(this);
        t.start();
    }
    public void run(){
            System.out.println("");
        final String username = "lemonteamcode@gmail.com";
        final String password = "fastrackit";




        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
           // message.setFrom(new InternetAddress("ionel.condor@gmail.com"));
            message.setRecipients (Message.RecipientType.TO,
                    InternetAddress.parse("dana777ramo@gmail.com"));
                            message.setSubject("Num-guess");
            message.setText("Congratulation!\n" + "Nr:" + nr + "\n" + "Tentatives:");

            Transport.send(message);

            System.out.println("done, email sent ok");

        } catch (Exception e) {
            System.out.println("Email sending problems");
            e.printStackTrace();
        }

    }
}
