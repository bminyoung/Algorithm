package me.nyoung.BOJ.BackTracking;

import java.util.Scanner;

public class sol_14888 {
    static int max;
    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        int[] op = new int[4];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        operation(0, numbers, op, 0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void operation(int current, int[] numbers, int[] op, int start) {
        if(start == 0) operation(numbers[0], numbers, op, 1);
        if(start == numbers.length) {
            if(max < current || max == Integer.MIN_VALUE) max = current;
            if(min > current || min == Integer.MAX_VALUE) min = current;
            return;
        }

        if(op[0] != 0){
            op[0]--;
            operation(current + numbers[start], numbers, op, start+1);
            op[0]++;
        }
        if(op[1] != 0){
            op[1]--;
            operation(current - numbers[start], numbers, op, start+1);
            op[1]++;
        }
        if(op[2] != 0){
            op[2]--;
            operation(current * numbers[start], numbers, op, start+1);
            op[2]++;
        }
        if(op[3] != 0){
            op[3]--;
            operation(current / numbers[start], numbers, op, start+1);
            op[3]++;
        }
    }
}
