package me.nyoung.BOJ.BinarySearch;

import java.util.Scanner;

public class sol_1654 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }

        long left = 1;
        long right = Integer.MAX_VALUE;
        long value, sum;
        long max = 0;
        while(left <= right){
            value = (left + right) / 2;
            sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i] / value;
            }

            if(sum >= N){
                left = value + 1;
                if(max < value) max = value;
            }else{
                right = value - 1;
            }
        }
        System.out.println(max);
    }
}
