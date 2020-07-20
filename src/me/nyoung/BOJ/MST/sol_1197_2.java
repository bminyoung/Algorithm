package me.nyoung.BOJ.MST;

import java.util.*;

//By Prim
public class sol_1197_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        PriorityQueue<Vertex> vertices = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V+1];

        List<Vertex>[] adj = new ArrayList[V+1];
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

        queue.add(1); //set start vertex
        int weightSum = 0;
        while(queue.size() != 0){
            // 선택된 정점과 연결된 간선 모두 vertices에 넣기
            int std = queue.poll();
            visited[std] = true;
            for (int i = 0; i < adj[std].size(); i++) {
                if(!visited[adj[std].get(i).end]){
                    vertices.add(adj[std].get(i));
                }
            }

            // weight가 가장 적은 간선을 꺼내서 확인하고 추가한다
            while(vertices.size() != 0){
                Vertex v = vertices.poll();
                if(!visited[v.end]){
                    queue.add(v.end);
                    weightSum += v.dist;
                    break;
                }
            }
        }
        System.out.println(weightSum);
    }
}

class Vertex implements Comparable<Vertex>{
    int start;
    int end;
    int dist;

    public Vertex(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Vertex v) {
        return this.dist - v.dist;
    }
}