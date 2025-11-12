package ppoo_decorator;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class PPOO_Decorator {

    public static void main(String[] args) {
        String remetente = "testejava75@gmail.com";
        String senha = "cblymnarnwcwijrs"; // senha de app gerada no Gmail
        String destinatario = "silvahigor142@gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Cria sessão com autenticação
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
            }
        });
        session.setDebug(true); // mostra logs no console

        try {
            Message email = new MimeMessage(session);
            email.setFrom(new InternetAddress(remetente));
            email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            email.setSubject("Teste JavaMail");
            email.setText("Este é um teste de envio de e-mail via JavaMail.");

            System.out.println("📨 Tentando enviar...");
            Transport.send(email);
            System.out.println("✅ E-mail enviado com sucesso!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
