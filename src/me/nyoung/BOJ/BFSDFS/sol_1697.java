package me.nyoung.BOJ.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sol_1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int goal = sc.nextInt();

        if(start >= goal) {
            System.out.println(start-goal);
            return;
        }

        int[] count = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(true){
            int std = queue.poll();
            if(std+1 <= 100000 && count[std+1] == 0){
                queue.add(std+1);
                count[std+1] = count[std]+1;
            }
            if(std-1 >= 0 && count[std-1] == 0){
                queue.add(std-1);
                count[std-1] = count[std]+1;
            }
            if(2*std <= 100000 && count[2*std] == 0){
                queue.add(2*std);
                count[2*std] = count[std]+1;
            }
            if(goal == std+1 || goal == std-1 || goal == 2*std) break;
        }
        System.out.println(count[goal]);
    }
}
