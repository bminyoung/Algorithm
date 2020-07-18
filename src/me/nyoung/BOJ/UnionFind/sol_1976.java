package me.nyoung.BOJ.UnionFind;

import java.util.Scanner;

public class sol_1976 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int city = sc.nextInt();
        int plan = sc.nextInt();
        int[] parent = new int[city+1];
        for (int i = 1; i <= city; i++) {
            parent[i] = i;
        }
        for (int from = 1; from <= city; from++) {
            for (int to = 1; to <= city ; to++) {
                if(sc.nextInt() == 1){
                    union(parent, from, to);
                }
            }
        }
        int root = findParent(parent, sc.nextInt());
        int i;
        for (i = 1; i < plan; i++) {
            if(root != findParent(parent, sc.nextInt())){
                System.out.println("NO");
                break;
            }
        }
        if(i == plan) System.out.println("YES");
    }

    private static void union(int[] parent, int first, int second) {
        int p1 = findParent(parent, first);
        int p2 = findParent(parent, second);

        if(p1 == p2) return;
        else if(p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;
    }

    private static int findParent(int[] parent, int child) {
        if(parent[child] == child) return child;
        return parent[child] = findParent(parent, parent[child]);
    }
}
