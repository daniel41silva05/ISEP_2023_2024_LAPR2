package mdisc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportarCsv {
    public static Grafo lerGrafoDeCSV(String nomeArquivo) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(nomeArquivo));

        Grafo grafo = new Grafo();

        while (scanner.hasNextLine()) {
            String[] linha = scanner.nextLine().split(";");
            int origem = Integer.parseInt(linha[0]);
            int destino = Integer.parseInt(linha[1]);
            int peso = Integer.parseInt(linha[2]);
            grafo.addAresta(origem, destino, peso);
            grafo.setVertice(Math.max(grafo.getVertice(), Math.max(origem, destino) + 1));
            grafo.setAresta(grafo.getAresta() + 1);
        }

        return grafo;
    }
}
