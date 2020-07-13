package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int target = sc.nextInt();
            if(target <= 1){
                System.out.println(1-target + " " + target);
                continue;
            }
            int[][] arr = new int[target+1][2];
            arr[0] = new int[]{1, 0};
            arr[1] = new int[]{0, 1};
            for(int j = 2; j <= target; j++){
                arr[j][0] = arr[j-1][0] + arr[j-2][0];
                arr[j][1] = arr[j-1][1] + arr[j-2][1];
            }
            System.out.println(arr[target][0] + " " + arr[target][1]);
        }
    }
}
