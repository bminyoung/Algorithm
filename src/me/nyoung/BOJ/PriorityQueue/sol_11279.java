package me.nyoung.BOJ.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class sol_11279 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int cmd = sc.nextInt();
            if(cmd == 0){
                if(queue.size() == 0) System.out.println(0);
                else System.out.println(queue.poll());
            }else{
                queue.add(cmd);
            }
        }
    }
}
