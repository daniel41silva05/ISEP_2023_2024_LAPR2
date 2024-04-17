package mdisc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Rota> rotas = ImportacaoCSV.importarRotas("rotas.csv");
        for (Rota rota : rotas) {
            System.out.println(rota);
        }
    }
}
