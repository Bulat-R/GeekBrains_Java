package alg.hw7;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int vertexCount = 10;
        Graph graph = new Graph(vertexCount);
        Random random = new Random();
        for (int i = 0; i < vertexCount; i++) {
            graph.addEdge(random.nextInt(vertexCount), random.nextInt(vertexCount));
        }

        System.out.println("================= GRAPH =================");
        for (int i = 0; i < vertexCount; i++) {
            System.out.printf("vertex %d edges: %s\n", i, graph.getAdjList(i));
        }
        System.out.println("=========================================\n");
        System.out.println("================ PATH TO ================");
        for (int i = 0; i < vertexCount; i++) {
            BreadthFirstPath bfp = new BreadthFirstPath(graph, i);
            for (int j = i + 1; j < vertexCount; j++) {
                if (bfp.hasPathTo(j)) {
                    System.out.printf("path from %d to %d: %s\n", i, j, bfp.pathTo(j));
                } else {
                    System.out.printf("path from %d to %d: %s\n", i, j, "no path");
                }
            }
        }
        System.out.println("=========================================");

    }
}
