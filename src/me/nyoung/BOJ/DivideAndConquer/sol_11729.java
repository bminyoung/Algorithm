package me.nyoung.BOJ.DivideAndConquer;

import java.io.IOException;
import java.util.Scanner;

public class sol_11729 {
    static StringBuilder sb;
    static int count;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        count = 0;
        int n = sc.nextInt();
        hanoi(n, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb.toString());
    }

    static void hanoi(int n, int from, int rem, int to) throws IOException {
        if(n == 1){
            sb.append(from + " " + to + "\n");
            count++;
            return;
        }
        hanoi(n-1, from, to, rem);
        hanoi(1, from, rem, to);
        hanoi(n-1, rem, from, to);
    }
}
