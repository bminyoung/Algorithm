package me.nyoung.BOJ.BinarySearch;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class sol_10816 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int target = sc.nextInt();
            bw.write(upperBound(arr, target) - lowerBound(arr, target) + " ");
        }
        bw.flush();
        bw.close();
    }

    static int upperBound(int[] arr, int target){
        int left = 0;
        int right = arr.length;
        int index;
        while(left < right){
            index = (left + right) / 2;
            if(arr[index] <= target){
                left = index + 1;
            }else{
                right = index;
            }
        }
        return right;
    }

    static int lowerBound(int[] arr, int target){
        int left = 0;
        int right = arr.length;
        int index;
        while(left < right){
            index = (left + right) / 2;
            if(arr[index] < target){
                left = index + 1;
            }else{
                right = index;
            }
        }
        return right;
    }
}
