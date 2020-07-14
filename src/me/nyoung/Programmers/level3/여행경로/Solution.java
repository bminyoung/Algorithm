package me.nyoung.Programmers.level3.여행경로;

import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        boolean[] visited = new boolean[tickets.length];

        Arrays.sort(tickets, (s1, s2) -> s1[1].compareTo(s2[1]));
        ArrayList<String> ways = new ArrayList<>();
        String std = "ICN";
        ways.add(std);

        ways = dfs(tickets, visited, std, ways);

        return ways.toArray(answer);
    }

    public ArrayList<String> dfs(String[][] tickets, boolean[] visited, String std, ArrayList<String> ways) {
        //all visit
        boolean test = true;
        for(boolean v : visited) test = test && v;
        if(test == true) return ways;

        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(std)) {
                visited[i] = true;
                ways.add(tickets[i][1]);
                ArrayList<String> tmp = dfs(tickets, visited, tickets[i][1], ways);
                if(tmp == null) { //roll back
                    ways.remove(ways.size()-1);
                    visited[i] = false;
                    continue;
                }
                ways = tmp;
            }
        }

        return ways.size() != tickets.length+1 ? null : ways;
    }
}