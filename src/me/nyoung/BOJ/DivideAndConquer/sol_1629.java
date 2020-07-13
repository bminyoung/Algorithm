package me.nyoung.BOJ.DivideAndConquer;

import java.util.Scanner;

public class sol_1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(power(a, b, c));
    }
    static int power(long a, int b, int c){
        if(b == 0){
            return 1;
        } else if(b == 1){
            return (int)(a%c);
        }else{
            long tmp = power(a, b/2, c);
            tmp = tmp*tmp % c;
            if(b % 2 == 0){
                return (int)tmp;
            }else{
                return (int)(tmp*a % c);
            }
        }
    }
}
