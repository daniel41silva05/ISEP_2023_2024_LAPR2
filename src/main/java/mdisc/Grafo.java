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

        try (FileWriter csvWriter = new FileWriter("src/main/java/mdisc/output_JardimDosSentimentos.csv");
             FileWriter dotWriter = new FileWriter("src/main/java/mdisc/output_JardimDosSentimentos.dot")) {

            csvWriter.append("Origem;Destino;Peso\n");
            dotWriter.write("graph G {\n");

            while (e < vertice - 1 && i < aresta) {
                Aresta proximaAresta = arestas.get(i++);

                int x = encontrar(subset, proximaAresta.getOrigem());
                int y = encontrar(subset, proximaAresta.getDestino());

                if (x != y) {
                    resultado[e++] = proximaAresta;
                    unir(subset, x, y);

                    csvWriter.append(String.valueOf(proximaAresta.getOrigem())).append(";").append(String.valueOf(proximaAresta.getDestino())).append(";").append(String.valueOf(proximaAresta.getPeso())).append("\n");
                    dotWriter.write("\t" + proximaAresta.getOrigem() + " -- " + proximaAresta.getDestino() + " [label=\"" + proximaAresta.getPeso() + "\"];\n");

                    custoTotal += proximaAresta.getPeso();
                }
            }

            csvWriter.append("Cost of a Minimum spanning tree = ").append(String.valueOf(custoTotal)).append("\n");
            dotWriter.write("}");

        } catch (IOException ex) {
            System.err.println("Erro ao escrever nos arquivos: " + ex.getMessage());
        }
    }

    public void gerarArquivoDOT(String arquivo) {
        try (FileWriter dotWriter = new FileWriter(arquivo)) {
            dotWriter.write("graph G {\n");

            for (Aresta a : arestas) {
                dotWriter.write("\t" + a.getOrigem() + " -- " + a.getDestino() + " [label=\"" + a.getPeso() + "\"];\n");
            }

            dotWriter.write("}");

        } catch (IOException ex) {
            System.err.println("Erro ao escrever no arquivo DOT: " + ex.getMessage());
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
