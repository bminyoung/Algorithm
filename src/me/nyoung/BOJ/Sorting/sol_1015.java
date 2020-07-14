package me.nyoung.BOJ.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class sol_1015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ret = solution(arr);
        for (int num : ret) {
            System.out.print(num + " ");
        }
    }

    public static int[] solution(int[] arr){
        int[] sort = arr.clone();
        Arrays.sort(sort);
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];

            for (int j = 0; j < arr.length; j++) {
                if(sort[j] == target){
                    result[i] = j;
                    sort[j] = -1; //duplicate
                    break;
                }
            }
        }
        return result;
    }
}
