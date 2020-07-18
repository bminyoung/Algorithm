package me.nyoung.BOJ.UnionFind;

import java.util.Scanner;

public class sol_1717 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int cmd, first, second;
        for (int i = 0; i < m; i++) {
            cmd = sc.nextInt();
            first = sc.nextInt();
            second = sc.nextInt();
            if(cmd == 0){
                union(parent, first, second);
            }else{
                int p1 = findParent(parent, first);
                int p2 = findParent(parent, second);
                if(p1 == p2) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static void union(int[] parent, int first, int second){
        int p1 = findParent(parent, first);
        int p2 = findParent(parent, second);

        if(p1 == p2) return;
        else if(p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;
    }

    public static int findParent(int[] parent, int child){
        if(parent[child] == child) return child;
        return parent[child] = findParent(parent, parent[child]);
    }
}
