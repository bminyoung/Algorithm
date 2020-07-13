package me.nyoung.BOJ.BinarySearch;

import java.util.Scanner;

public class sol_12015 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        d[0] = arr[0];

        int index = 0;
        for (int i = 1; i < n; i++) {
            if(d[index] < arr[i]) {
                index++;
                d[index] = arr[i];
            }else{
                int lbLoc = lowerBound(d, 0, index, arr[i]);
                d[lbLoc] = arr[i];
            }
        }
        System.out.println(++index);
    }

    static int lowerBound(int[] arr, int left, int right, int target){
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
