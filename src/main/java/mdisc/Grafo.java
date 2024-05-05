package mdisc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Grafo {
    private int vertice;
    private int aresta;
    private ArrayList<Aresta> arestas;

    public Grafo() {
        arestas = new ArrayList<>();
    }

    public void addAresta(int origem, int destino, int peso) {
        arestas.add(new Aresta(origem, destino, peso));
    }

    public int encontrar(int[] subset, int i) {
        if (subset[i] == -1)
            return i;
        return encontrar(subset, subset[i]);
    }

    public void unir(int[] subset, int x, int y) {
        int xroot = encontrar(subset, x);
        int yroot = encontrar(subset, y);
        subset[xroot] = yroot;
    }

    public void encontrarArvoreGeradora() {
        Aresta[] resultado = new Aresta[vertice];
        int e = 0;
        int i = 0;
        int custoTotal = 0;

        for (i = 0; i < vertice; ++i)
            resultado[i] = new Aresta(0, 0, 0);

        Collections.sort(arestas);

        int[] subset = new int[vertice];
        Arrays.fill(subset, -1);

        i = 0;

        try (FileWriter writer = new FileWriter("output_JardimDosSentimentos.csv")) {
            while (e < vertice - 1 && i < aresta) {
                Aresta proximaAresta = arestas.get(i++);

                int x = encontrar(subset, proximaAresta.getOrigem());
                int y = encontrar(subset, proximaAresta.getDestino());

                if (x != y) {
                    resultado[e++] = proximaAresta;
                    unir(subset, x, y);

                    writer.append(String.valueOf(proximaAresta.getOrigem())).append(";").append(String.valueOf(proximaAresta.getDestino())).append(";").append(String.valueOf(proximaAresta.getPeso())).append("\n");

                    custoTotal += proximaAresta.getPeso();
                }
            }

            writer.append("Cost of a Minimum spanning tree = ").append(String.valueOf(custoTotal)).append("\n");

            System.out.println("Arquivo 'output_JardimDosSentimentos' criado com sucesso.");

        } catch (IOException ex) {
            System.err.println("Erro ao escrever no arquivo CSV: " + ex.getMessage());
        }
    }

    public int getAresta() {
        return aresta;
    }

    public void setAresta(int a1) {
        aresta = a1;
    }

    public int getVertice() {
        return vertice;
    }

    public void setVertice(int v1) {
        vertice = v1;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }
}
