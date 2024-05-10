package mdisc;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Grafo grafo = ImportarCsv.lerGrafoDeCSV("datasets mdisc/US13_JardimDosSentimentos.csv");

            grafo.gerarArquivoDOT("src/main/java/mdisc/input_JardimDosSentimentos.dot");
            String[] cmd1 = {"dot", "-Tpng", "src/main/java/mdisc/input_JardimDosSentimentos.dot", "-o", "src/main/java/mdisc/input_JardimDosSentimentos.png"};
            gerarImagemDoGrafo(cmd1);

            String[] cmd2 = {"dot", "-Tpng", "src/main/java/mdisc/output_JardimDosSentimentos.dot", "-o", "src/main/java/mdisc/output_JardimDosSentimentos.png"};
            grafo.encontrarArvoreGeradora();
            gerarImagemDoGrafo(cmd2);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        }
    }

    public static void gerarImagemDoGrafo(String[] cmd) {
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao gerar a imagem do grafo: " + e.getMessage());
        }
    }

}

