package me.nyoung.BOJ.MST;

import java.util.PriorityQueue;
import java.util.Scanner;

public class sol_4386 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            vertices[i] = new Vertex(i, x, y);
        }
        for (int i = 0; i < n; i++) {
            Vertex start = vertices[i];
            for (int j = 0; j < n; j++) {
                if(i != j){
                    Vertex end = vertices[j];
                    double dist = Math.sqrt((start.x - end.x)*(start.x - end.x) + (start.y - end.y)*(start.y - end.y));
                    edges.add(new Edge(start.number, end.number, dist));
                }
            }
        }
        int[] root = new int[n];
        init(root);
        double sum = 0;
        int count = 0;
        while(count < n-1) {
            Edge e = edges.poll();
            if(isCycle(root, e.v1, e.v2)) continue;
            sum += e.dist;
            union(root, e.v1, e.v2);
            count++;
        }
        System.out.printf("%.2f", sum);
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
        double x;
        double y;
        int root;

        public Vertex(int number, double x, double y) {
            this.number = number;
            this.x = x;
            this.y = y;
            this.root = number;
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

