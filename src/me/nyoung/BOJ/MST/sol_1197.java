package me.nyoung.BOJ.MST;

import java.util.Arrays;
import java.util.Scanner;

//By Kruskal
public class sol_1197 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[] parent = new int[V+1];
        init(parent);
        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            if(from > to){
                int tmp = from;
                from = to;
                to = tmp;
            }
            edges[i] = new Edge(from, to, weight);
        }
        Arrays.sort(edges);
        int sum = 0;
        for (int i = 0; i < edges.length; i++) {
            if(isCycle(parent, edges[i].v1, edges[i].v2)) continue;
            union(parent, edges[i].v1, edges[i].v2);
            sum += edges[i].weight;
        }
        System.out.println(sum);
    }

    static void init(int[] parent){
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    // 이미 같은 그룹인 정점을 이으면 사이클 발생
    static boolean isCycle(int[] parent, int a, int b){
        return findParent(parent, a) == findParent(parent, b);
    }

    static void union(int[] parent, int a, int b){
        int p1 = findParent(parent, a);
        int p2 = findParent(parent, b);

        if(p1 < p2) parent[p2] = p1;
        else if(p1 > p2) parent[p1] = p2;
    }

    private static int findParent(int[] parent, int child) {
        if(parent[child] == child) return child;
        return parent[child] = findParent(parent, parent[child]);
    }
}

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}
