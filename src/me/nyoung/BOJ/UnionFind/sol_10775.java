package me.nyoung.BOJ.UnionFind;

import java.util.Scanner;

public class sol_10775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gate = sc.nextInt();
        int planeNum = sc.nextInt();
        boolean[] use = new boolean[gate + 1];
        int[] parent = new int[gate + 1];
        for (int i = 1; i <= gate; i++) { // initialize
            parent[i] = i;
        }
        for (int i = 0; i < planeNum; i++) {
            int plane = sc.nextInt();
            // 최대한 plane == gate 가 되도록, 사용중이면 -1씩하면서 체크
            if (use[plane] == true) {
                plane--;
                while (plane > 0) {
                    if (use[plane] == false) break;
                    plane--;
                }
                if (plane <= 0) break; //for loop break, 공항 폐쇄
            }
            use[plane] = true;
            union(use, parent, plane);
        }
        int count = 0;
        for (int i = 1; i <= gate; i++) {
            if(use[i]) count++;
        }
        System.out.println(count);
    }

    private static void union(boolean[] use, int[] parent, int plane) {
        int left = plane-1;
        int right = plane+1;
        if(left >= 1 && use[left]) union(parent, left, plane);
        if(right < parent.length && use[right]) union(parent, right, plane);
    }

    private static void union(int[] parent, int from, int to){
        int p1 = findParent(parent, from);
        int p2 = findParent(parent, to);
        if(p1 < p2){
            parent[p2] = p1;
        }else if(p2 < p1){
            parent[p1] = p2;
        }
    }

    private static int findParent(int[] parent, int child) {
        if(parent[child] == child) return child;
        return parent[child] = findParent(parent, parent[child]);
    }
}
