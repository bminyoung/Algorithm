package me.nyoung.BOJ.Graph;

import java.util.*;

public class sol_18352 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int start = sc.nextInt();
        List<Integer>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[from].add(to);
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, 300001);
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.dist));
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(queue.size() != 0){
            Node now = queue.poll();
            for(int to : adj[now.to]){
                if(dist[to] > dist[now.to] + 1){
                    dist[to] = dist[now.to] + 1;
                    queue.add(new Node(to, dist[to]));
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(dist[i] == k) {
                count++;
                System.out.println(i);
            }
        }
        if(count == 0) System.out.println(-1);
    }

    static class Node{
        int to;
        int dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
}
