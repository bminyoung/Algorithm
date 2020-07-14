package me.nyoung.Programmers.level1.실패율;

import java.util.*;

class Solution {
    public class FailRate{
        int stage;
        double rate;
        FailRate(int stage, double rate){
            this.stage = stage;
            this.rate = rate;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<FailRate> fail = new ArrayList<>();
        Arrays.sort(stages);

        int cnt = 0;
        for(int i = 1; i <= N; i++) { //stage
            int succ = 0;
            int denom = stages.length-cnt;
            for(int j = cnt; j < stages.length && stages[j] == i; j++, cnt++) {
                succ++;
            }
            fail.add(new FailRate(i, succ * 1.0 / denom));
        }

        Collections.sort(fail, new Comparator<FailRate>() {
            @Override
            public int compare(FailRate o1, FailRate o2) {
                // TODO Auto-generated method stub
                if(o1.rate < o2.rate) return 1;
                else if(o1.rate > o2.rate) return -1;
                else return 0;
            }
        });

        for(int i = 0; i < N; i++) {
            answer[i] = fail.get(i).stage;
        }

        return answer;
    }
}