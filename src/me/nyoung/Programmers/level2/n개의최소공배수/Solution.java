package me.nyoung.Programmers.level2.n개의최소공배수;

public class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++){
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    public int lcm(int num1, int num2){
        int larger = num1 > num2 ? num1 : num2;
        int small = num1 <= num2 ? num1 : num2;
        int init = larger;

        while(true){
            if(larger % small == 0){
                return larger;
            }
            larger += init;
        }
    }
}
