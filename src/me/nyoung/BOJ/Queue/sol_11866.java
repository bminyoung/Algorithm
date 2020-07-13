package me.nyoung.BOJ.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sol_11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        sb.append("<");

        while(queue.size() > 1){
            for (int i = 0; i < k-1; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }
        sb.append(queue.poll() + ">");
        System.out.println(sb.toString());
    }
}
