package me.nyoung.BOJ.Graph;

import java.util.*;

public class sol_1504 {
    static final int MAX = 800001;
    static List<Vertex>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        adj = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            adj[from].add(new Vertex(from, to, weight));
            adj[to].add(new Vertex(to, from, weight));
        }
        int[] mustPass = new int[]{sc.nextInt(), sc.nextInt()};
        int[] d1 = find(1);
        int[] d2 = find(mustPass[0]);
        int[] d3 = find(mustPass[1]);

        int way1 = d1[mustPass[0]] + d2[mustPass[1]] + d3[V]; // 1 -> v1 -> v2 -> V
        int way2 = d1[mustPass[1]] + d3[mustPass[0]] + d2[V]; // 1 -> v2 -> v1 -> V
        int min = Math.min(way1, way2);
        System.out.println(min >= MAX ? -1 : min);
    }

    static int[] find(int start){
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.weight));
        int[] dist = new int[adj.length];
        Arrays.fill(dist, MAX);
        queue.add(new Vertex(start, start, 0));
        dist[start] = 0;
        while(queue.size() != 0){
            Vertex now = queue.poll();

            for(Vertex vtx : adj[now.to]){
                if(dist[vtx.to] > dist[now.to] + vtx.weight){
                    dist[vtx.to] = dist[now.to] + vtx.weight;
                    queue.add(new Vertex(now.from, vtx.to, (int)dist[vtx.to]));
                }
            }
        }
        return dist;
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
