package mdisc;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Ler o grafo da US13
            String ficheiro = "datasets mdisc\\US13_JardimDosSentimentos.csv";
            Grafo.gerarOutputExcel(ficheiro, "src\\main\\java\\mdisc\\output_menor_caminho.csv");
            Aresta[] resultado = ImportarCsv.lerGrafoDeCSV(ficheiro).toArray(new Aresta[0]);

            Grafo.generateDotFile(resultado, "src\\main\\java\\mdisc\\input_grafo.dot");
            Grafo.renderDotFile("src\\main\\java\\mdisc\\input_grafo.dot", "src\\main\\java\\mdisc\\input_grafo.png");

            // Executar os testes de algoritmo da US14
            String inicioNome = "datasets mdisc\\us14_";
            String outputFile = "src\\main\\java\\mdisc\\execution_time.csv";
            String outputFilePng = "src\\main\\java\\mdisc\\execution_time_graph.png";
            Grafo.runAlgorithmTests(inicioNome, outputFile, outputFilePng);

        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }

}
