package com.pilab.xyz.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Dfs {

    static int[][] adj = {
        {0, 0, 1, 0, 0, 1, 0, 0},
        {1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 1},
        {0, 1, 0, 0, 0, 0, 0, 0}
    };

    public static void main(String[] args) {
//        for (int i = 0; i < adj.length; i++) {
//            System.out.print((i+1)+"-> ");
//            for (int j = 0; j < adj.length; j++) {
//                System.out.print(adj[i][j]+", ");                
//            }
//            System.out.println("");
//        }

        Graph g = new Graph(8, adj);
        dfs(g, 0);
        bfs(g, 0);
    }

    public static void bfs(Graph g, int startNode) {
        System.out.println("\nBFS Iterative");
        Queue<Integer> s = new LinkedList<>();
        s.add(startNode);
        int[] visited = new int[g.v];

        while (!s.isEmpty()) {
            Integer node = s.poll();
            if (visited[node] == 1) {
                continue;
            } else {
                visited[node] = 1;
            }

            System.out.print(node + ", ");

            int nocolum = 7;
            while (nocolum >= 0) {
                int item = g.adj[node][nocolum];
                if (item > 0) {
                    s.add(nocolum);
                }
                nocolum--;
            }
        }
    }    
    
    public static void dfs(Graph g, int startNode) {
        System.out.println("\nDFS Iterative");
        Stack<Integer> s = new Stack();
        s.add(startNode);
        int[] visited = new int[g.v];

        while (!s.isEmpty()) {
            Integer node = s.pop();
            if (visited[node] == 1) {
                continue;
            } else {
                visited[node] = 1;
            }

            System.out.print(node + ", ");

            int nocolum = g.adj[node].length-1;
            while (nocolum >= 0) {
                int item = g.adj[node][nocolum];
                if (item > 0) {
                    s.add(nocolum);
                }
                nocolum--;
            }
        }
    }
}

class Graph {

    public int v;
    public int[][] adj;

    public Graph(int v, int[][] adj) {
        this.v = v;
        this.adj = adj;
    }
}
