package mdisc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportacaoCSV {
    public static List<Rota> importarRotas(String nomeArquivo) {
        List<Rota> rotas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            // Ignorando cabeçalho
            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String pontoX = dados[0].trim();
                String pontoY = dados[1].trim();
                double distancia = Double.parseDouble(dados[2].trim());
                rotas.add(new Rota(pontoX, pontoY, distancia));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rotas;
    }
}
