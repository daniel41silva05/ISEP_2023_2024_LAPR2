package pprog.ui;

import pprog.repository.Repositories;

import java.io.*;

public class testarSerializacao {
    public static void main(String[] args) {
        try {
            // Abra um FileInputStream para ler o arquivo .ltf
            FileInputStream fileIn = new FileInputStream("src\\main\\resources\\config.properties.xml");

            // Crie um ObjectInputStream para ler objetos do FileInputStream
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            // Desserializar objeto(s)
            Repositories repositories = (Repositories) objectIn.readObject();

//            // Faça o cast do objeto deserialization para o tipo apropriado (ListaTelefonica)
//            SkillRepository lista = (SkillRepository) obj;

            System.out.println(repositories);

            // Fechar fluxos
            objectIn.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
