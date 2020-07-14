package me.nyoung.BOJ.Greedy;

public class sol_5585 {
    public int solution(int n){
        int[] money = new int[]{500, 100, 50, 10, 1};
        int cost = 1000 - n;
        int count = 0;

        for(int i = 0; i < money.length; i++){
            count += cost / money[i];
            cost %= money[i];
        }

        return count;
    }
}
