package me.nyoung.BOJ.Math;

import java.util.Scanner;

public class sol_2981 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] diff = new int[n-1];
        nums[0] = sc.nextInt();
        for (int i = 1; i < n; i++) {
            nums[i] = sc.nextInt();
            diff[i-1] = Math.abs(nums[i] - nums[i-1]);
        }
        int gcd = gcd(diff);
        for (int i = 2; i <= gcd/2; i++) {
            if(gcd % i == 0) System.out.println(i);
        }
        System.out.println(gcd);
    }

    private static int gcd(int[] diff) {
        int gcd = diff[0];
        for (int i = 1; i < diff.length; i++) {
            gcd = gcd(gcd, diff[i]);
        }
        return gcd;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
