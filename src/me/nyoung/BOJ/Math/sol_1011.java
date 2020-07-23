package me.nyoung.BOJ.Math;

import java.util.Scanner;

public class sol_1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int goal = y - x; // 칸 수가 중요
            int count;
            double sqrt = Math.sqrt(goal);
            if(sqrt - (int)sqrt == 0){ //goal = 제곱수
                count = 2*(int)sqrt - 1;
            }
            else{
                int n = (int)sqrt + 1;
                int std = n*n - n;
                if(std < goal){
                    count = 2*n-1;
                }else{
                    count = 2*n-2;
                }
            }
            System.out.println(count);
        }
    }
    /*
    * 횟수 1 2 3 4 5  6  7  8  9 ...
    * 칸수 1 2 4 6 9 12 16 20 25 ...
    * 1 11 121 1221 12321 123321 1234321 12344321 ...
    * */
}
