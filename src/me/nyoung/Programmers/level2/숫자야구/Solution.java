package me.nyoung.Programmers.level2.숫자야구;

public class Solution {
    public int solution(int[][] baseball) {
        int[] numbers = new int[9*8*7];
        int index = 0;
        for(int i = 1; i < 10; i++) {
            for(int j = 1; j < 10; j++) {
                if(i == j) continue;
                for(int k = 1; k < 10; k++) {
                    if(j == k || k == i) continue;
                    numbers[index++] = i*100 + j*10 + k;
                }
            }
        }

        for(int i = 0; i < baseball.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
                int number = numbers[j];
                if(number == -1) continue;

                if (strike(number, baseball[i][0]) != baseball[i][1]) { numbers[j] = -1; }
                if (ball(number, baseball[i][0]) != baseball[i][2]) { numbers[j] = -1; }
            }
        }
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > 0) count++;
        }
        return count;
    }

    int ball(int ans, int num) {
        int count = 0;

        int[] digits = new int[] { num / 100, (num %100) / 10, num%10 };
        for(int digit : digits) {
            if(ans / 100 == digit && ans / 100 != num / 100
                    || (ans % 100) / 10 == digit && (ans % 100) / 10 != (num % 100) / 10
                    || ans % 10 == digit && ans % 10 != num % 10) {
                count++;
            }
        }

        return count;
    }

    int strike(int ans, int num) {
        int count = 0;

        if(ans / 100 == num / 100) count++;
        if ((ans % 100) / 10 == (num % 100) / 10) count++;
        if (ans % 10 == num % 10) count++;

        return count;
    }
}
