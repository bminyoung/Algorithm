package me.nyoung.BOJ.BruteForce;

import java.util.Scanner;

public class sol_2966 {

    public void solution(){
        String[] pattern = new String[]{"ABC", "BABC", "CCAABB"};
        String[] id = new String[]{"Adrian", "Bruno", "Goran"};
        int[] count = new int[3];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String answers = sc.next();

        for(int i = 0; i < n; i++){
            char answer = answers.charAt(i);
            for(int j = 0; j < 3; j++){
                if(pattern[j].charAt(i % pattern[j].length()) == answer) count[j]++;
            }
        }

        int max = 0;
        for(int c : count){
            if(max < c) max = c;
        }
        System.out.println(max);
        for(int i = 0; i < 3; i++){
            if(count[i] == max) System.out.println(id[i]);
        }

    }
}
