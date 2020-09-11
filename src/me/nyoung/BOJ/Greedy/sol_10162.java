package me.nyoung.BOJ.Greedy;

import java.util.Scanner;

public class sol_10162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] time = {300, 60, 10}; // time[i] = time[i-1]의 배수 -> greedy
        int[] count = new int[3];
        int goal = sc.nextInt();
        for (int i = 0; i < 3; i++) {
            count[i] = goal / time[i];
            goal %= time[i];
        }
        if(goal != 0) System.out.println(-1);
        else{
            for (int i = 0; i < 3; i++) {
                System.out.print(count[i] + " ");
            }
        }

    }
}
