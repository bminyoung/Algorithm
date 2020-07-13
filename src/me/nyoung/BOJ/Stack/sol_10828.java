package me.nyoung.BOJ.Stack;

import java.util.Scanner;

public class sol_10828 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = 0;
        int[] stack = new int[10000];
        sc.nextLine();

        for(int i = 0; i < n; i++){
            String cmd = sc.nextLine();
            if(cmd.equals("pop")){
                if(size == 0) System.out.println(-1);
                else{
                    System.out.println(stack[size-1]);
                    stack[size-- -1] = 0;
                }
            }else if(cmd.equals("size")){
                System.out.println(size);
            }else if(cmd.equals("empty")){
                if(size == 0) System.out.println(1);
                else System.out.println(0);
            }else if(cmd.equals("top")){
                if(size == 0) System.out.println(-1);
                else System.out.println(stack[size-1]);
            }else{
                stack[size++] = Integer.parseInt(cmd.split(" ")[1]);
            }
        }
    }
}
