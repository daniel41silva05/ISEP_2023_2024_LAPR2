package pprog.domain;

import pprog.interfaces.Email;
import pprog.session.ApplicationSession;

public class EmailService {

    public static void sendToEmailFile(String gsmEmail, String collaboratorEmail, String collaboratorName, String entry) {
        String subject = "Assignment to a task";
        String body = "Hello " + collaboratorName + ".\nYou have been assigned a task that is in the Agenda, so you have become responsible for carrying it out.\n" + "Below is the task information:\n" + entry + "\n";
        Email e = null;
        try {
            e = ApplicationSession.getEmailService();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        e.sendEmail(gsmEmail, collaboratorEmail, subject, body);
    }

}
