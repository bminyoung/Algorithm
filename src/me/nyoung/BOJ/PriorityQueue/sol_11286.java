package me.nyoung.BOJ.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class sol_11286 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new absComp());
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
    static class absComp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(Math.abs(o2) == Math.abs(o1)){
                return o1 > o2 ? 1 : -1;
            }
            else return Math.abs(o1) - Math.abs(o2);
        }
    }
}
