package me.nyoung.BOJ.Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class sol_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int cnt = 0; cnt < T; cnt++) {
            int n = sc.nextInt();
            int loc = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            int order = 1;
            while(arr.size() != 0){
                int max = Collections.max(arr);
                int index = arr.indexOf(max);
                if(index == loc) {
                    System.out.println(order);
                    break;
                }
                for (int i = 0; i < index; i++) {
                    arr.add(arr.remove(0));
                }
                loc = loc - index - 1;
                if(loc < 0) loc += arr.size();

                arr.remove(0);
                order++;
            }
        }
    }
}
