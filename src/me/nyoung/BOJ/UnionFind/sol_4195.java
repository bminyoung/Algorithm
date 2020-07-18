package me.nyoung.BOJ.UnionFind;

import java.util.HashMap;
import java.util.Scanner;

public class sol_4195 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int count = sc.nextInt();
            HashMap<String, Integer> map = new HashMap<>(); // name + number
            int[][] parent = new int[count * 2 + 1][2]; //number + count
            for (int j = 1; j < parent.length; j++) {
                parent[j] = new int[]{j, 1};
            }
            for (int j = 0; j < count; j++) {
                String friend1 = sc.next();
                String friend2 = sc.next();
                if(map.get(friend1) == null) map.put(friend1, map.size()+1);
                if(map.get(friend2) == null) map.put(friend2, map.size()+1);
                union(parent, map.get(friend1), map.get(friend2));
                System.out.println(parent[findParent(parent, map.get(friend1))][1]);
                //parent class로 구현하는게 가독성이 좋을것같다
            }
        }
    }

    public static void union(int[][] parent, int first, int second){
        int p1 = findParent(parent, first);
        int p2 = findParent(parent, second);

        if(p1 != p2){
            parent[p2][1] = parent[p1][1] = parent[p2][1] + parent[p1][1];
            if(p1 < p2){
                parent[p2][0] = p1;
            }else{
                parent[p1][0] = p2;
            }
        }
    }

    private static int findParent(int[][] parent, int child) {
        if(parent[child][0] == child) return child;
        int p = findParent(parent, parent[child][0]);
        parent[child][0] = p;
        parent[child][1] = parent[p][1];
        return p;
    }
}
