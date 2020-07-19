package me.nyoung.BOJ.MST;

import java.util.Scanner;

public class sol_9372 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int nation = sc.nextInt();
            int plane = sc.nextInt();
            for (int j = 0; j < plane; j++) {
                sc.nextInt(); sc.nextInt();
            }
            System.out.println(nation - 1);
            // must be mst, #edge = vertex - 1
        }
    }
}
