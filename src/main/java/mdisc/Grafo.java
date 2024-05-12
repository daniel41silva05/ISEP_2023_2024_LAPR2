package mdisc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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

    public void encontrarArvoreGeradoraUS13() {
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

        try (FileWriter writer = new FileWriter("src/main/java/mdisc/output_JardimDosSentimentos.csv")) {
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

            generateDotFile(resultado, "src/main/java/mdisc/output_JardimDosSentimentos.dot");

            renderDotFile("src/main/java/mdisc/output_JardimDosSentimentos.dot", "src/main/java/mdisc/output_JardimDosSentimentos.png");

            System.out.println("Arquivo 'output_JardimDosSentimentos' criado com sucesso.");

        } catch (IOException ex) {
            System.err.println("Erro ao escrever no arquivo CSV: " + ex.getMessage());
        }
    }

    public void encontrarArvoreGeradoraUS14() {
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

            while (e < vertice - 1 && i < aresta) {
                Aresta proximaAresta = arestas.get(i++);

                int x = encontrar(subset, proximaAresta.getOrigem());
                int y = encontrar(subset, proximaAresta.getDestino());

                if (x != y) {
                    resultado[e++] = proximaAresta;
                    unir(subset, x, y);

                    custoTotal += proximaAresta.getPeso();
                }
            }

    }

    public void generateDotFile(Aresta[] resultado, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);

        writer.write("graph G {\n");
        for (Aresta aresta : resultado) {
            if (aresta.getPeso() != 0) {
                writer.write(aresta.getOrigem() + " -- " + aresta.getDestino() + " [label=\"" + aresta.getPeso() + "\"];\n");
            }
        }
        writer.write("}\n");

        writer.close();
    }

    public void renderDotFile(String dotFileName, String outputFileName) throws IOException {
        String[] cmd = {"dot", "-Tpng", dotFileName, "-o", outputFileName};
        Runtime.getRuntime().exec(cmd);
    }

    public void runAlgorithmTests() {
        try (FileWriter csvWriter = new FileWriter("src/main/java/mdisc/execution_times.csv")) {
            csvWriter.append("Tamanho da Entrada,Tempo de Execução (ms)\n");

            for (int i = 1; i <= 30; i++) {
                Grafo grafo = ImportarCsv.lerGrafoDeCSV("datasets mdisc/us14_" + i + ".csv");

                long startTime = System.currentTimeMillis();
                grafo.encontrarArvoreGeradoraUS14();
                long endTime = System.currentTimeMillis();
                long executionTime = endTime - startTime;

                csvWriter.append(i + "," + executionTime + "\n");
            }

            csvWriter.flush();

            List<String> lines = Files.readAllLines(Paths.get("src/main/java/mdisc/execution_times.csv"));
            int[] inputSizes = new int[lines.size() - 1];
            long[] executionTimes = new long[lines.size() - 1];

            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                inputSizes[i - 1] = Integer.parseInt(parts[0]);
                executionTimes[i - 1] = Long.parseLong(parts[1]);
            }

            generateExecutionTimeGraphic(inputSizes, executionTimes, "src/main/java/mdisc/execution_time_graph.png");

        } catch (IOException ex) {
            System.err.println("Erro ao escrever no arquivo CSV: " + ex.getMessage());
        }
    }

    public void generateExecutionTimeGraphic(int[] inputSizes, long[] executionTimes, String outputFileName) {
        try {
            String gnuplotCommands = "set terminal png\n"
                    + "set output '" + outputFileName + "'\n"
                    + "set title 'Tempos de Execução'\n"
                    + "set xlabel 'Tamanho da Entrada'\n"
                    + "set ylabel 'Tempo de Execução (ms)'\n"
                    + "plot '-' with lines title 'Tempo de Execução'\n";

            for(int i = 0; i < inputSizes.length; ++i) {
                gnuplotCommands += inputSizes[i] + " " + executionTimes[i] + "\n";
            }

            gnuplotCommands += "e\n";

            ProcessBuilder processBuilder = new ProcessBuilder("gnuplot");
            Process process = processBuilder.start();
            process.getOutputStream().write(gnuplotCommands.getBytes());
            process.getOutputStream().flush();
            process.getOutputStream().close();
            int exitCode = process.waitFor();
            System.out.println("Código de saída do Gnuplot: " + exitCode);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
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
