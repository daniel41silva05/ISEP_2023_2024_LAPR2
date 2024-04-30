package mdisc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

    public class Grafo {
        private int V;
        private int E;
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

        public void kruskal() {
            Aresta[] resultado = new Aresta[V];
            int e = 0;
            int i = 0;
            for (i = 0; i < V; ++i)
                resultado[i] = new Aresta(0, 0, 0);

            Collections.sort(arestas);

            int[] subset = new int[V];
            Arrays.fill(subset, -1);

            i = 0;

            try (FileWriter writer = new FileWriter("output_JardimDosSentimentos.csv")) {
                while (e < V - 1 && i < E) {
                    Aresta proximaAresta = arestas.get(i++);

                    int x = encontrar(subset, proximaAresta.getOrigem());
                    int y = encontrar(subset, proximaAresta.getDestino());

                    if (x != y) {
                        resultado[e++] = proximaAresta;
                        unir(subset, x, y);

                        writer.append(proximaAresta.getOrigem() + ";" + proximaAresta.getDestino() + ";" + proximaAresta.getPeso() + "\n");
                    }
                }

                System.out.println("Rotas de minimo custo acumulado:");
                int custoTotal = 0;
                for (i = 0; i < e; ++i) {
                    System.out.println(resultado[i].getOrigem() + " - " + resultado[i].getDestino() + ": " + resultado[i].getPeso());
                    custoTotal += resultado[i].getPeso();
                }
                System.out.println("Custo total: " + custoTotal);
                System.out.println("Arquivo 'output_JardimDosSentimentos' criado com sucesso.");

            } catch (IOException ex) {
                System.err.println("Erro ao escrever no arquivo CSV: " + ex.getMessage());
            }
        }

        public int getE() {
            return E;
        }

        public void setE(int e) {
            E = e;
        }

        public int getV() {
            return V;
        }

        public void setV(int v) {
            V = v;
        }

        public ArrayList<Aresta> getArestas() {
            return arestas;
        }

        public void setArestas(ArrayList<Aresta> arestas) {
            this.arestas = arestas;
        }
    }
