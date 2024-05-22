package pprog.domain;

public interface Email {

    void sendEmail(String from, String to, String subject, String body);
}
