package me.nyoung.Programmers.level1.모의고사;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] solution(int[] answers) {
        int[] correct = new int[3];
        int[] first = new int[] {1, 2, 3, 4, 5};
        int[] second = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == first[i % 5]) correct[0]++;
            if(answers[i] == second[i % 8]) correct[1]++;
            if(answers[i] == third[i % 10]) correct[2]++;
        }

        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if(max < correct[i]){
                max = correct[i];
                list.clear();
                list.add(i+1);
            }else if(max == correct[i]){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
