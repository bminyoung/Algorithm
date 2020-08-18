package me.nyoung.BOJ.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sol_1167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Node>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int from = sc.nextInt();
            int to;
            while((to = sc.nextInt()) != -1){
                adj[from].add(new Node(to, sc.nextInt()));
            }
        }

        // 기준점(아무거나)에서 가장 먼 노드 구하기
        int startPoint = findMax(adj, 1)[0];
        // 그 노드로부터 가장 먼 노드 구하기 (=지름)
        System.out.println(findMax(adj, startPoint)[1]);
    }

    private static int[] findMax(ArrayList<Node>[] adj, int start) {
        int n = adj.length;
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        queue.add(start);

        while(queue.size() != 0){
            int std = queue.poll();
            visited[std] = true;
            ArrayList<Node> arr = adj[std];
            for (Node node : arr) {
                if(visited[node.endPoint]) continue;

                queue.add(node.endPoint);
                dist[node.endPoint] = dist[std] + node.dist;
            }
        }

        int max = 0;
        int maxNode = 0;
        for (int i = 0; i < n; i++) {
            if(max < dist[i]){
                max = dist[i];
                maxNode = i;
            }
        }

        return new int[]{maxNode, max};
    }

    static class Node{
        int endPoint;
        int dist;

        public Node(int endPoint, int dist) {
            this.dist = dist;
            this.endPoint = endPoint;
        }
    }
}

