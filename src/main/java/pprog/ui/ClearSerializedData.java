package pprog.ui;

import pprog.repository.Repositories;

import java.io.*;

public class ClearSerializedData {
    public static void main(String[] args) {
        try {

            String filePath = "src\\main\\resources\\config.properties.xml";

            Repositories repositories = Repositories.getInstance();

            repositories.clearData();

            repositories.saveSystemStateToBinary(new File(filePath));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

