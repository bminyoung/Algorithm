package me.nyoung.BOJ.Queue;

import java.util.LinkedList;
import java.util.Scanner;

public class sol_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i <= len; i++) {
            queue.add(i);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            int index = queue.indexOf(arr[i])+1;
            int count = queue.size() - index + 1;
            if(count < index - 1){ //to left
                for (int j = 0; j < count; j++) {
                    queue.add(0, queue.pollLast());
                }
            }else{ //to right
                count = index-1;
                for (int j = 0; j < count; j++) {
                    queue.addLast(queue.poll());
                }
            }
            queue.poll();
            total += count;
        }
        System.out.println(total);
    }
}
