package me.nyoung.BOJ.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class sol_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        String[] tmp;
        int a, b;
        for (int i = 0; i < n-1; i++) {
            tmp = br.readLine().split(" ");
            a = Integer.parseInt(tmp[0]);
            b = Integer.parseInt(tmp[1]);
            arr[a].add(b);
            arr[b].add(a);
        }

        int[] tree = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while(queue.size() != 0){
            int parent = queue.poll();
            for (int i : arr[parent]) {
                if(visited[i]) continue;
                queue.add(i);
                tree[i] = parent;
                visited[i] = true;
            }
        }

        for (int i = 2; i <= n; i++) {
            bw.write(tree[i]+"\n");
        }
        bw.flush();
    }
}
