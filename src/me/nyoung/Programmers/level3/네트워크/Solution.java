package me.nyoung.Programmers.level3.네트워크;

public class Solution {
    boolean[] conn = new boolean[200];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(conn[i]) continue;
            answer++;
            check(i, n, computers);
        }

        return answer;
    }

    void check(int index, int n, int[][] computers) {
        conn[index] = true;
        for (int i = 0; i < n; i++) {
            if (computers[index][i] == 1 && !conn[i]) {
                check(i, n, computers);
            }
        }
    }
}
