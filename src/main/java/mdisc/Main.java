package mdisc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Rota> rotas = ImportacaoCSV.importarRotas("datasets mdisc/JardimDosSentimentos.csv");
        for (Rota rota : rotas) {
            System.out.println(rota);
        }
    }
}
