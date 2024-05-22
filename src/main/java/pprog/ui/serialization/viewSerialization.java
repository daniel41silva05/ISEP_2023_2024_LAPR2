package pprog.ui.serialization;

import pprog.repository.Repositories;

import java.io.*;

public class viewSerialization {
    public static void main(String[] args) {
        try {

            FileInputStream fileIn = new FileInputStream("src\\main\\resources\\config.properties.xml");

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Repositories repositories = (Repositories) objectIn.readObject();

            System.out.println(repositories);

            objectIn.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
