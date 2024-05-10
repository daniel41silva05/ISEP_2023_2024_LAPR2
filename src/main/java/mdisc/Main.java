package mdisc;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            // Ler o grafo da US13
            Grafo grafoUS13 = ImportarCsv.lerGrafoDeCSV("datasets mdisc/US13_JardimDosSentimentos.csv");
            grafoUS13.encontrarArvoreGeradoraUS13();

            // Executar os testes de algoritmo da US14
            Grafo grafoUS14 = new Grafo();
            grafoUS14.runAlgorithmTests();

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}
