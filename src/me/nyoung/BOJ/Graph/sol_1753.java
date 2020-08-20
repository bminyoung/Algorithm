package me.nyoung.BOJ.Graph;

import java.util.*;

public class sol_1753 {
    static final int MAX = 200001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int start = sc.nextInt();
        List<Vertex>[] adj = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            Vertex v = new Vertex(from, to, weight);
            adj[from].add(v);
        }

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.weight));
        int[] d = new int[V+1];
        Arrays.fill(d, MAX);
        queue.add(new Vertex(start, start, 0));
        d[start] = 0;
        while(queue.size() != 0){
            Vertex now = queue.poll();

            for(Vertex vtx : adj[now.to]){
                if(d[vtx.to] > d[now.to] + vtx.weight){
                    d[vtx.to] = d[now.to] + vtx.weight;
                    queue.add(new Vertex(now.from, vtx.to, d[vtx.to]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            System.out.println(d[i] == MAX ? "INF" : d[i]);
        }
    }

    static class Vertex{
        int from;
        int to;
        int weight;

        public Vertex(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
