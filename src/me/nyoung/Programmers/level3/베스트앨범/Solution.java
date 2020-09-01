package me.nyoung.Programmers.level3.베스트앨범;

import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, List<Song>> songMap = new HashMap<>(); // {genre, songList}
        HashMap<String, Integer> totalTime = new HashMap<>();
        HashSet<String> genreSet = new HashSet<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playTime = plays[i];
            Song song = new Song(i, genre, playTime);
            if(!genreSet.contains(genre)){
                genreSet.add(genre);

                List<Song> songList = new ArrayList<>();
                songList.add(song);
                songMap.put(genre, songList);
                totalTime.put(genre, playTime);
            }else{
                playTime = totalTime.get(genre) + playTime;
                totalTime.put(genre, playTime);

                List<Song> songList = songMap.get(genre);
                songList.add(song);
            }
        }
        List<String> list = new ArrayList(totalTime.keySet());
        Collections.sort(list, (s1, s2) -> totalTime.get(s2) - totalTime.get(s1));

        List<Integer> sort = new ArrayList<>();
        for (String genre : list) {
            List<Song> songList = songMap.get(genre);
            Collections.sort(songList, (s1, s2) -> s2.playTime - s1.playTime);
            sort.add(songList.get(0).number);
            if(songList.size() > 1) sort.add(songList.get(1).number);
        }

        int[] answer = new int[sort.size()];
        for (int i = 0; i < sort.size(); i++) {
            answer[i] = sort.get(i);
        }
        return answer;
    }

    class Song implements Comparator<Song> {
        int number;
        String genre;
        int playTime;

        public Song(int number, String genre, int playTime) {
            this.number = number;
            this.genre = genre;
            this.playTime = playTime;
        }

        @Override
        public int compare(Song s1, Song s2) {
            return s1.playTime-s2.playTime;
        }
    }
}
