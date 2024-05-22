package pprog.domain;

import pprog.session.ApplicationSession;

import java.io.IOException;

public class EmailService {

    public static void sendToEmailFile(String from, String to, String subject, String body) throws IOException {
        Email e = null;
        try {
            e = ApplicationSession.getEmailService();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        e.sendEmail(from, to, subject, body);
    }

}
