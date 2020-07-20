package me.nyoung.BOJ.MST;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class sol_2887 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            vertices[i] = new Vertex(i, x, y, z); //vertex number + coordinate
        }

        // add edge (not all edge)
        addEdge(edges, vertices, Comparator.comparingInt(v -> v.x));
        addEdge(edges, vertices, Comparator.comparingInt(v -> v.y));
        addEdge(edges, vertices, Comparator.comparingInt(v -> v.z));

        int[] root = new int[n];
        init(root);
        int sum = 0;
        int count = 0;
        while(count < n-1) {
            Edge e = edges.poll();
            if(isCycle(root, e.v1, e.v2)) continue;
            sum += e.dist;
            union(root, e.v1, e.v2);
            count++;
        }
        System.out.println(sum);
    }

    private static void addEdge(PriorityQueue<Edge> edges, Vertex[] vertices, Comparator<Vertex> comp) {
        Arrays.sort(vertices, comp);
        for (int i = 0; i < vertices.length - 1; i++) {
            Vertex start = vertices[i];
            Vertex end = vertices[i+1];
            edges.add(new Edge(start.number, end.number, dist(start, end)));
        }
    }

    static int dist(Vertex v1, Vertex v2){
        return Math.min(Math.min(Math.abs(v1.x - v2.x), Math.abs(v1.y - v2.y)), Math.abs(v1.z-v2.z));
    }

    static boolean isCycle(int[] root, int a, int b){
        return find(root, a) == find(root, b);
    }

    private static void init(int[] root) {
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }
    }

    static void union(int[] root, int v1, int v2){
        int p1 = find(root, v1);
        int p2 = find(root, v2);

        if(p1 < p2) root[p2] = p1;
        else if(p1 > p2) root[p1] = p2;
    }

    private static int find(int[] root, int v) {
        if(root[v] == v) return v;
        return root[v] = find(root, root[v]);
    }

    static class Vertex{
        int number;
        int x;
        int y;
        int z;

        public Vertex(int number, int x, int y, int z) {
            this.number = number;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        double dist;

        public Edge(int v1, int v2, double dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge e) {
            if(this.dist > e.dist) return 1;
            else if(this.dist < e.dist) return -1;
            else return 0;
        }
    }
}
