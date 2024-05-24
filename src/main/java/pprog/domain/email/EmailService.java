package pprog.domain.email;

import pprog.session.ApplicationSession;

public class EmailService {

    public static void sendToEmailFile(String from, String to, String nameCollaborator, String task) {
        String subject = "Assignment to a task";
        String body = "Olá " + nameCollaborator + ".\nYou have been assigned a task that is in the Agenda, so you have become responsible for carrying it out.\n" + "Below is the task information:\n" + task + "\n";
        Email e = null;
        try {
            e = ApplicationSession.getEmailService();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        e.sendEmail(from, to, subject, body);
    }

}
