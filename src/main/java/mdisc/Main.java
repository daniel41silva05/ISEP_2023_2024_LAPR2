package mdisc;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Ler o grafo da US13
            Grafo grafoUS13 = ImportarCsv.lerGrafoDeCSV("datasets mdisc/US13_JardimDosSentimentos.csv");
            grafoUS13.generateDotFile(grafoUS13.getArestas().toArray(new Aresta[0]), "src/main/java/mdisc/input_JardimDosSentimentos.dot");
            grafoUS13.renderDotFile("src/main/java/mdisc/input_JardimDosSentimentos.dot", "src/main/java/mdisc/input_JardimDosSentimentos.png");
            System.out.println("Imagem do grafo de input gerada com sucesso.");
            grafoUS13.encontrarArvoreGeradoraUS13();

            // Executar os testes de algoritmo da US14
            Grafo grafoUS14 = new Grafo();
            grafoUS14.runAlgorithmTests();

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
