package mdisc.SprintC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Graph {
    private int[][] adjacencyMatrix;
    private String[] points;

    public Graph(String matrixFile, String pointsFile) throws IOException {
        readMatrix(matrixFile);
        readPoints(pointsFile);
    }

    private void readMatrix(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int size = 0;
        while ((line = br.readLine()) != null) {
            size++;
        }
        br.close();

        adjacencyMatrix = new int[size][size];
        br = new BufferedReader(new FileReader(file));
        int row = 0;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(";");
            for (int col = 0; col < values.length; col++) {
                adjacencyMatrix[row][col] = Integer.parseInt(values[col].replaceAll("[^\\d]", ""));
            }
            row++;
        }
        br.close();
    }

    private void readPoints(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        if (line != null) {
            points = line.replaceAll("[^\\x20-\\x7E]", "").split(";");
        }
        br.close();
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public String[] getPoints() {
        return points;
    }
}
