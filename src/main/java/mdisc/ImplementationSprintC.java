package mdisc;

import java.io.FileNotFoundException;
import java.util.*;

public class ImplementationSprintC {

    private List<Aresta> grafo;

    public ImplementationSprintC(String nomeArquivo) throws FileNotFoundException {
        this.grafo = ImportarCsv.lerGrafoDeCSV(nomeArquivo);
    }

    public List<String> encontrarCaminhoMaisCurto(String origem) {
        Map<String, Integer> distancias = new HashMap<>();
        Map<String, String> predecessores = new HashMap<>();
        PriorityQueue<String> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (Aresta aresta : grafo) {
            distancias.put(aresta.getOrigem(), Integer.MAX_VALUE);
            distancias.put(aresta.getDestino(), Integer.MAX_VALUE);
        }
        distancias.put(origem, 0);
        filaPrioridade.add(origem);

        while (!filaPrioridade.isEmpty()) {
            String vertice = filaPrioridade.poll();
            for (Aresta aresta : grafo) {
                if (aresta.getOrigem().equals(vertice)) {
                    int distanciaNova = distancias.get(vertice) + aresta.getPeso();
                    if (distanciaNova < distancias.get(aresta.getDestino())) {
                        distancias.put(aresta.getDestino(), distanciaNova);
                        predecessores.put(aresta.getDestino(), vertice);
                        filaPrioridade.add(aresta.getDestino());
                    }
                }
            }
        }

        List<String> caminho = new ArrayList<>();
        String pontoAtual = "Assembly Point";
        while (!pontoAtual.equals(origem)) {
            caminho.add(pontoAtual);
            pontoAtual = predecessores.get(pontoAtual);
        }
        caminho.add(origem);
        Collections.reverse(caminho);

        return caminho;
    }

    public void exportarResultados(String origem, String nomeArquivo) {
        try {
            List<String> caminhoMaisCurto = encontrarCaminhoMaisCurto(origem);
            int duracao = calcularDuracao(caminhoMaisCurto);
            StringBuilder resultado = new StringBuilder();
            for (String vertice : caminhoMaisCurto) {
                resultado.append(vertice).append(", ");
            }
            resultado.append(duracao);
            // Escrever o resultado em um arquivo CSV
            // Exemplo: vertice1, vertice2, ..., Assembly Point; duracao
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int calcularDuracao(List<String> caminho) {
        // Calcular a duração total do caminho
        return caminho.size() - 1; // Número de arestas
    }
}

