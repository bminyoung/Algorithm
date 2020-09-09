package me.nyoung.BOJ.BruteForce;

import java.util.Arrays;
import java.util.Scanner;

public class sol_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] height = new int[9];
        int goal = 0;
        for (int i = 0; i < 9; i++) {
            height[i] = sc.nextInt();
            goal += height[i];
        }
        goal -= 100;

        Arrays.sort(height);
        boolean check = false;
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if(height[i] + height[j] == goal){
                    for (int k = 0; k < 9; k++) {
                        if(k == i || k == j) continue;
                        System.out.println(height[k]);
                    }
                    check = true;
                }
                if(check) break;
            }
            if(check) break;
        }
    }
}
