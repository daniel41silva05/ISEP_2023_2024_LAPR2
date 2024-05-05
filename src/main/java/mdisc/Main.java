package mdisc;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            Grafo grafo = ImportarCsv.lerGrafoDeCSV("datasets mdisc/US13_JardimDosSentimentos.csv");
            grafo.encontrarArvoreGeradora();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}

