package kg.backend.meniki.service.email;

public interface EmailService {

    void sendEmail(String to, String subject, String body);
}
