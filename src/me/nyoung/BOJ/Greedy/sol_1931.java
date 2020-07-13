package me.nyoung.BOJ.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class sol_1931 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }
        Arrays.sort(arr, (n1, n2) -> n1[1] == n2[1] ? n1[0]-n2[0] : n1[1]-n2[1]);
        int count = 1;
        int select = 0;
        for (int i = 1; i < n; i++) {
            if(arr[i][0] < arr[select][1]) continue;
            select = i;
            count++;
        }
        System.out.println(count);
    }
}
