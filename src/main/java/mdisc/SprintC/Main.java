package mdisc.SprintC;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            Graph graph = new Graph("datasets mdisc\\us17_matrix.csv", "datasets mdisc\\us17_points_names.csv");
            int[][] adjacencyMatrix = graph.getAdjacencyMatrix();
            String[] points = graph.getPoints();

            int startVertex = findAPIndex(graph.getPoints());

            Dijkstra dijkstra = new Dijkstra(adjacencyMatrix.length);
            dijkstra.computeShortestPathsUs17(adjacencyMatrix, startVertex);

            try (FileWriter writer = new FileWriter("src\\main\\java\\mdisc\\SprintC\\caminhosUS17.csv")) {
                for (int i = 0; i < adjacencyMatrix.length; i++) {
                    if (i != startVertex) {
                        String path = Dijkstra.reconstructPathUs17(dijkstra.getPredecessors(), i, startVertex, points);
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

        try {
            Graph graph = new Graph("datasets mdisc\\us18_matrix.csv", "datasets mdisc\\us18_points_names.csv");
            int[][] adjacencyMatrix = graph.getAdjacencyMatrix();
            String[] points = graph.getPoints();

            List<Integer> startVertices = findAPIndexes(points);
            int[] startVerticesArray = startVertices.stream().mapToInt(i -> i).toArray();

            Dijkstra dijkstra = new Dijkstra(adjacencyMatrix.length);
            dijkstra.computeShortestPathsUs18(adjacencyMatrix, startVerticesArray);

            try (FileWriter writer = new FileWriter("src\\main\\java\\mdisc\\SprintC\\caminhosUS18.csv")) {
                for (int i = 0; i < adjacencyMatrix.length; i++) {
                    if (!startVertices.contains(i)) {
                        String path = Dijkstra.reconstructPathUs18(dijkstra.getPredecessors(), i, points);
                        String[] pathElements = path.split(";");
                        StringBuilder reversedPath = new StringBuilder();
                        for (int j = pathElements.length - 1; j >= 0; j--) {
                            reversedPath.append(pathElements[j]);
                            if (j != 0) {
                                reversedPath.append(";");
                            }
                        }
                        writer.write(reversedPath + "\n");
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

    private static List<Integer> findAPIndexes(String[] points) {
        List<Integer> apIndexes = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            if (points[i].startsWith("AP")) {
                apIndexes.add(i);
            }
        }
        return apIndexes;
    }
}
