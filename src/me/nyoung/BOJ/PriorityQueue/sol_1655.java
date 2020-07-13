package me.nyoung.BOJ.PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class sol_1655 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> max = new PriorityQueue<>();

        int middle = sc.nextInt();
        System.out.println(middle);
        for (int i = 1; i < n; i++) {
            int num = sc.nextInt();
            if(num > middle) max.add(num);
            else min.add(num);

            while(min.size() > max.size()){
                max.add(middle);
                middle = min.poll();
            }
            while(max.size()-min.size() > 1){
                min.add(middle);
                middle = max.poll();
            }
            System.out.println(middle);
        }
    }
}
