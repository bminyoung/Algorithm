package me.nyoung.Programmers.level3.줄서는방법;

import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        int index = 0;
        int person;
        long std = 1;
        ArrayList<Integer> people = new ArrayList();
        people.add(0);
        for(int i = 1; i <= n; i++) {
            people.add(i);
        }

        for (int i = 2; i <= n; i++) std *= i;

        while(n > 0) {
            std /= n;
            person = (int)(k/std);
            k %= std;
            if(k%std != 0) person++;

            answer[index++] = people.remove(person);
            n--;
            if(k == 0) k = std;
        }

        return answer;
    }
}