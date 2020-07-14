package me.nyoung.Programmers.level3.셔틀버스;

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<String> waiting = new LinkedList();

        Arrays.sort(timetable);
        for(int i = 0; i < timetable.length; i++) waiting.add(timetable[i]);
        timetable = makeTimeTable(n, t); //bus

        String wait = "09:00";
        boolean isFull = false;

        for(int i = 0; i < timetable.length; i++) {
            String bus = timetable[i];
            boolean isOver = false;
            for(int index = 0; index < m; index++) {
                if(waiting.size() != 0) wait = waiting.peek();
                isFull = false;
                if(waiting.size() == 0 || diff(wait, bus) < 0) {
                    isOver = true;
                    break;
                }else {
                    wait = waiting.poll();
                }
            }

            if(waiting.size() == 0) {
                return isOver ? timetable[n-1] : calcTime(wait, -1);
            }else if(!isOver){
                isFull = true;
            }
        }

        String first = waiting.peek();
        return diff(first, timetable[n-1]) >= 0 || isFull ? calcTime(wait, -1) : timetable[n-1];
    }

    public String[] makeTimeTable(int n, int t) {
        String[] table = new String[n];
        table[0] = "09:00";
        for(int i = 1; i < n; i++) {
            table[i] = calcTime(table[i-1], t);
        }

        return table;
    }

    public String calcTime(String time, int minute) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]) + minute;

        while(min >= 60 || min < 0) {
            if(min >= 60) {
                min -= 60;
                hour++;
            }else if(min < 0) {
                hour--;
                min += 60;
            }
        }

        if(hour == 24) hour = 0;
        else if(hour < 0) hour += 24;

        return String.format("%02d:%02d", hour, min);
    }

    public int diff(String t1, String t2) {
        String[] h1 = t1.split(":");
        String[] h2 = t2.split(":");

        if(h1[0].equals(h2[0])) {
            return Integer.parseInt(h2[1]) - Integer.parseInt(h1[1]);
        }else {
            return Integer.parseInt(h2[0]) - Integer.parseInt(h1[0]);
        }
    }
}