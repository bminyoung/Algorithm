package me.nyoung.Programmers.level3.추석트래픽;

import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        Log[] logs = new Log[lines.length];
        Arrays.sort(lines);

        for(int i = 0; i < logs.length; i++) {
            logs[i] = strToSec(lines[i]);
        }

        int process = 0;
        for(int i = 0; i < lines.length; i++) {
            Log time = logs[i];
            process = 0;

            //시작 기준
            double std = time.start;
            for(int j = 0; j < lines.length; j++) {
                Log comp = logs[j];
                if(std > comp.end ||
                        comp.start >= std+1.0) continue;
                process++;
            }
            if(process > answer) answer = process;

            //끝 기준
            std = time.end;
            process = 0;
            for(int j = 0; j < lines.length; j++) {
                Log comp = logs[j];
                if(std > comp.end ||
                        comp.start >= std+1.0) continue;
                process++;
            }
            if(process > answer) answer = process;
        }

        return answer;
    }

    class Log{
        double start;
        double end;
        Log(double start, double end){
            this.start = start;
            this.end = end;
        }
    }

    Log strToSec(String str) {
        String[] tmp = str.split(" ");
        String[] time = tmp[1].split(":");
        double lasting = Double.parseDouble(tmp[2].substring(0, tmp[2].length()-1));
        int hourAndMin = Integer.parseInt(time[0])*3600 + Integer.parseInt(time[1])*60;
        double end = Double.parseDouble(time[2]);
        double start = end - lasting + 0.001;

        return new Log(start+hourAndMin, end+hourAndMin);
    }
}