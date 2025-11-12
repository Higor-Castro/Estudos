package Model.Decorator;

import Model.Usuario;
import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailDecorator extends BaseNotifierDecorator {

    private static final Logger logger = Logger.getLogger(MailDecorator.class.getName());

    public MailDecorator(INotifier wrapped, Usuario usuario) {
        super(wrapped, usuario);
    }

    @Override
    public void send(String msg) {
        // Chama o notifier anterior, se existir
        if (super.wrapped != null) {
            super.send(msg);
        }

        // Validação do usuário
        if (usuario == null || usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            logger.warning("Usuário inválido ou e-mail ausente. Nenhum e-mail será enviado.");
            return;
        }

        String remetente = "testejava75@gmail.com";
        String senha = "cblymnarnwcwijrs"; // App password
        String destinatario = usuario.getEmail();

        try {
            // Configurações SMTP
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            // Cria sessão com autenticação
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(remetente, senha);
                }
            });

            // Cria a mensagem
            Message email = new MimeMessage(session);
            email.setFrom(new InternetAddress(remetente));
            email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            email.setSubject("Consulta de Metas");
            email.setText(msg);

            // Envia em thread separada para não travar a página
            new Thread(() -> {
                try {
                    Transport.send(email);
                    logger.info("✅ Email enviado com sucesso para: " + destinatario);
                } catch (MessagingException e) {
                    logger.severe("❌ Erro ao enviar e-mail para: " + destinatario);
                    e.printStackTrace();
                }
            }).start();

        } catch (Exception e) {
            logger.severe("❌ Erro inesperado ao configurar envio de e-mail: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
