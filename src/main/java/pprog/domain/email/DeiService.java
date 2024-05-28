package pprog.domain.email;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DeiService implements Email {

    @Override
    public void sendEmail(String from, String to, String subject, String body) {

        String fileName = "email.txt";

        File f = new File(fileName);
        if (f.exists()) {
            writeToFile(f, from, to, subject, body);
        } else {
            try {
                f.createNewFile();
                writeToFile(f, from, to, subject, body);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void writeToFile(File file, String from, String to, String subject, String body) {
        try {
            FileWriter send = new FileWriter(file, true);
            send.write("Email Service: Dei Service\nFrom: "+ from + "\nTo: " + to + "\nSubject: " + subject + "\n" + body + "\n");
            send.flush();
            send.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
