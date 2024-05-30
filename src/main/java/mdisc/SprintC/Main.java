package mdisc.SprintC;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Graph graph = new Graph("datasets mdisc\\us17_matrix.csv", "datasets mdisc\\us17_points_names.csv");
            int[][] adjacencyMatrix = graph.getAdjacencyMatrix();
            String[] points = graph.getPoints();

            int startVertex = findAPIndex(graph.getPoints());

            Dijkstra dijkstra = new Dijkstra(adjacencyMatrix.length);
            dijkstra.computeShortestPaths(adjacencyMatrix, startVertex);

            try (FileWriter writer = new FileWriter("src\\main\\java\\mdisc\\SprintC\\caminhosUS17.csv")) {
                for (int i = 0; i < adjacencyMatrix.length; i++) {
                    if (i != startVertex) {
                        String path = Dijkstra.reconstructPath(dijkstra.getPredecessors(), i, startVertex, points);
                        String[] pathElements = path.split(";");
                        StringBuilder reversedPath = new StringBuilder();
                        for (int j = pathElements.length - 1; j >= 0; j--) {
                            reversedPath.append(pathElements[j]);
                            if (j != 0) {
                                reversedPath.append(";");
                            }
                        }
                        writer.write(reversedPath.toString() + "\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findAPIndex(String[] points) {
        for (int i = 0; i < points.length; i++) {
            if (points[i].equals("AP")) {
                return i;
            }
        }
        return -1;
    }

//    // Método para encontrar os índices dos pontos de acesso ("AP")
//    private static List<Integer> findAPIndices(String[] points) {
//        List<Integer> apIndices = new ArrayList<>();
//        for (int i = 0; i < points.length; i++) {
//            if (points[i].startsWith("AP")) {
//                apIndices.add(i);
//            }
//        }
//        return apIndices;
//    }

}
