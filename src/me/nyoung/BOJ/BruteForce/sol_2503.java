package me.nyoung.BOJ.BruteForce;

public class sol_2503 {
    public boolean solution(int hund, int ten, int one, int number, int strike, int ball){
        int s = 0, b = 0;
        int[] answer = new int[]{hund, ten, one};
        int[] num = new int[]{number / 100, (number%100) / 10, number % 10};
        for(int i = 0; i < 3; i++){
            if(num[i] == answer[i]){
                s++;
                num[i] = 0;
                continue;
            }
            for(int j = 0; j < 3; j++){
                if(i == j) continue;
                if(num[i] == answer[j]){
                    b++;
                    num[i] = 0;
                }
            }
        }
        return s == strike && b == ball;
    }
}
