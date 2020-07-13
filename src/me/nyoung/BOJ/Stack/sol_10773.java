package me.nyoung.BOJ.Stack;

import java.util.Scanner;
import java.util.Stack;

public class sol_10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            if(num == 0){
                stack.pop();
            }else{
                stack.push(num);
            }
        }
        int sum = 0;
        for (Integer i: stack) {
            sum += i;
        }
        System.out.println(sum);
    }
}
