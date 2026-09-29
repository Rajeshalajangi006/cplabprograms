import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.*;

public class Solution {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] capacity = new int[V][V];

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cap = sc.nextInt();
            capacity[u][v] += cap;
        }

        System.out.println(maxFlow(capacity, 0, V - 1));
    }

    public static int maxFlow(int[][] capacity, int source, int sink) {
        int V = capacity.length;
        int[][] residual = new int[V][V];
        for (int i = 0; i < V; i++) {
            residual[i] = Arrays.copyOf(capacity[i], V);
        }

        int maxFlow = 0;
        int[] parent = new int[V];

        while (bfs(residual, source, sink, parent)) {
            int pathFlow = INF;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residual[u][v]);
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residual[u][v] -= pathFlow;
                residual[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    private static boolean bfs(int[][] residual, int source, int sink, int[] parent) {
        int V = residual.length;
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < V; v++) {
                if (!visited[v] && residual[u][v] > 0) {
                    parent[v] = u;
                    visited[v] = true;
                    q.add(v);
                    if (v == sink) return true;
                }
            }
        }
        return false;
    }
}
