package ejercicio2.services;

import ejercicio2.model.Notificacion;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class ServiceMensaje implements Notificacion {

    public static final String ASUNTO_SALUDO_DE_CUMPLEAÑOS = "Saludo de cumpleaños :";
    private final String username;
    private final String password;
    private final String habilitarAutenticacion;
    private final String activarSoporteTLS;
    private final String host;
    private final String puerto;


    public ServiceMensaje(String pwd, String username, String habilitarAutenticacion, String activarSoporteTLS1, String host, String puerto1) {
        this.password = pwd;
        this.username = username;
        this.habilitarAutenticacion = habilitarAutenticacion;
        this.activarSoporteTLS = activarSoporteTLS1;
        this.host = host;
        this.puerto = puerto1;

    }

    @Override
    public void enviarEmail(String destinatario, String mensaje) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", this.habilitarAutenticacion);
        props.put("mail.smtp.starttls.enable", this.activarSoporteTLS);
        props.put("mail.smtp.host", this.host);
        props.put("mail.smtp.port", this.puerto);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("no-reply@tuapp.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            msg.setSubject(ASUNTO_SALUDO_DE_CUMPLEAÑOS);
            msg.setText(mensaje);
            Transport.send(msg);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}