package me.nyoung.BOJ.BinarySearch;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class sol_1920 {
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
            int index = n/2;
            int left = 0;
            int right = n-1;
            int value = arr[index];
            while(value != target && left < right){
                if(value < target){
                    left = index + 1;
                }else{
                    right = index - 1;
                }
                index = (left + right)/2;
                value = arr[index];
            }
            if(value == target) bw.write('1');
            else bw.write('0');
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
