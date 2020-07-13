package me.nyoung.BOJ.DP;

import java.util.Scanner;

public class sol_1912 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        int max = num;
        int sum = num;

        for(int i = 1; i < n; i++){
            num = sc.nextInt();
            sum += num;
            if(sum < num) sum = num;
            if(max < sum) max = sum;
        }

        System.out.println(max);
    }
}
