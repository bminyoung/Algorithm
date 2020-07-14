package me.nyoung.Programmers.level2.방금그곡;

import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        MusicInfo[] infos = new MusicInfo[musicinfos.length];
        ArrayList<MusicInfo> satis = new ArrayList<>();

        for(int i = 0; i < musicinfos.length; i++) {
            String[] tmp = musicinfos[i].split(",");
            infos[i] = new MusicInfo(tmp[0], tmp[1], tmp[2], convertCode(tmp[3]), convertTime(tmp[0], tmp[1]));
        }
        m = convertCode(m);

        for(int i = 0; i < infos.length; i++) {
            MusicInfo info = infos[i];
            int repeat = info.playTime / info.code.length();
            for(int j = 0; j < repeat+1; j++) {
                info.fullCode.append(info.code);
            }
            info.fullCode.delete(info.playTime, info.fullCode.length()-1);

            if(info.fullCode.toString().contains(m)){
                satis.add(info);
            }
        }

        if(satis.size() == 0) {
            answer = "(None)";
        }
        else if(satis.size() == 1) {
            answer = satis.get(0).title;
        }else {
            MusicInfo music = satis.get(0);
            for(MusicInfo comp : satis) {
                if(music.playTime < comp.playTime) {
                    music = comp;
                }
            }
            answer = music.title;
        }

        return answer;
    }
    public String convertCode(String code) {
        return code.replace("A#", "a").replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g");
    }

    public int convertTime(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");
        int time = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]) -
                (Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]));

        return time;
    }

    class MusicInfo{
        String startTime;
        String endTime;
        String title;
        String code;
        StringBuilder fullCode = new StringBuilder();
        int playTime;

        MusicInfo(String st, String et, String t, String s, int time) {
            startTime = st;
            endTime = et;
            title = t;
            code = s;
            playTime = time;
        }
    }
}