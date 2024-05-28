package pprog.domain.email;

import pprog.domain.collaborator.Collaborator;

public interface Email {

    void sendEmail(String from, String to, String subject, String body);

}
