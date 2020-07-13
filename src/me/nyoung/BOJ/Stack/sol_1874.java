package me.nyoung.BOJ.Stack;

import java.util.Scanner;
import java.util.Stack;

//care of timeout
public class sol_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int index = 0;
        int number = 1;
        while(index < n && number <= n){
            for (int i = number; i <= arr[index]; i++) {
                stack.push(i);
                number = i+1;
                sb.append("+\n");
            }
            while(stack.size() != 0 && stack.peek() == arr[index]){
                stack.pop();
                sb.append("-\n");
                index++;
            }
            if(stack.size() != 0 && stack.peek() > arr[index]) break;
        }

        while(stack.size() != 0 && index < n){
            if(stack.peek() == arr[index++]){
                stack.pop();
                sb.append("-\n");
            }
        }

        if(stack.size() != 0){
            System.out.println("NO");
        }else{
            System.out.println(sb.toString());
        }
    }
}
