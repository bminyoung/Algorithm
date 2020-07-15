package me.nyoung.Programmers.level2.영어끝말잇기;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        List<String> before = new ArrayList<>();
        before.add(words[0]);
        char last = words[0].charAt(words[0].length() - 1);
        int i = 1;
        for (; i < words.length; i++) {
            if (words[i].charAt(0) != last || before.contains(words[i])) {
                break;
            }
            before.add(words[i]);
            last = words[i].charAt(words[i].length() - 1);
        }

        if (i == words.length) return answer;
        answer[0] = i % n + 1;
        answer[1] = i / n + 1;

        return answer;
    }
}
