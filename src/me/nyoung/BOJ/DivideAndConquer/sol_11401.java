package me.nyoung.BOJ.DivideAndConquer;

import java.util.Scanner;

public class sol_11401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long num = fact(n);
        long den = (fact(k)%div)*(fact(n-k)%div);
        den %= div;
        den = power(den, div-2, div);
        System.out.println((num*den)%div);
    }

    static int div = 1000000007;
    static long fact(int n){
        if(n <= 1) return 1;
        return (fact(n-1) * n) % div;
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
