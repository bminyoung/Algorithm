package me.nyoung.BOJ.Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class sol_15681 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int root = sc.nextInt();
        int query = sc.nextInt();
        adj = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[from].add(to);
            adj[to].add(from);
        }

        int[] nodes = new int[n+1];
        numOfNodes(root, nodes);

        for (int i = 0; i < query; i++) {
            int node = sc.nextInt();
            System.out.println(nodes[node]);
        }
    }

    private static int numOfNodes(int root, int[] nodes) {
        nodes[root] += 1;
        visited[root] = true;
        for(int num : adj[root]){
            if(visited[num]) continue;
            nodes[root] += numOfNodes(num, nodes);
        }
        return nodes[root];
    }
}
