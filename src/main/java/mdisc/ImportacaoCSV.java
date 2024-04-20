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
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                int pontoX = Integer.parseInt(dados[0].trim());
                int pontoY = Integer.parseInt(dados[1].trim());
                int distancia = Integer.parseInt(dados[2].trim());
                rotas.add(new Rota(pontoX, pontoY, distancia));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rotas;
    }
}
