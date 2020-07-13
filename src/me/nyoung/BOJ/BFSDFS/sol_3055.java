package me.nyoung.BOJ.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sol_3055 {

    static final int[] x = new int[]{0,0,1,-1};
    static final int[] y = new int[]{1,-1,0,0};

    public String solution(){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        Queue<Coord> waterQ = new LinkedList<>();
        Queue<Coord> hedgeQ = new LinkedList<>();
        int[][] ways = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        char[][] map = new char[row][col];
        for(int i = 0; i < row; i++){
            String tmp = sc.next();
            map[i] = tmp.toCharArray();

            if(tmp.contains("S")){
                hedgeQ.add(new Coord(i, tmp.indexOf('S')));
                map[i] = tmp.toCharArray();
            }
            if(tmp.contains("*")){
                waterQ.add(new Coord(i, tmp.indexOf('*')));
            }
        }

        while(hedgeQ.size() != 0){
            int waterCount = waterQ.size();
            int hedgeCount = hedgeQ.size();
            Coord coord;
            for(int i = 0; i < hedgeCount; i++){
                if( (coord = hedgeMove(map, hedgeQ, ways, visited)) != null){
                    return ways[coord.row][coord.col]+"";
                }
            }

            for(int i = 0; i < waterCount; i++){
                fillWater(map, waterQ, ways, visited);
            }
        }

        return "KAKTUS";
    }

    public void fillWater(char[][] map, Queue<Coord> waterQ, int[][] ways, boolean[][] visited){
        int row = map.length;
        int col = map[0].length;
        Coord water = waterQ.poll();
        if(visited[water.row][water.col]) return;
        visited[water.row][water.col] = true;

        for (int i = 0; i < 4; i++) {
            int nRow = water.row + x[i];
            int nCol = water.col + y[i];

            if(nRow < 0 || nRow >= row || nCol < 0 || nCol >= col
                    || visited[nRow][nCol]) continue;

            if(map[nRow][nCol] != '*' && map[nRow][nCol] != 'D' && map[nRow][nCol] != 'X'){
                ways[nRow][nCol] = -1;
                waterQ.add(new Coord(nRow, nCol));
            }
        }
    }

    public Coord hedgeMove(char[][] map, Queue<Coord> hedgeQ, int[][] ways, boolean[][] visited){
        int row = map.length;
        int col = map[0].length;
        Coord hedge = hedgeQ.poll();
        if(ways[hedge.row][hedge.col] == -1 || visited[hedge.row][hedge.col]) return null;
        visited[hedge.row][hedge.col] = true;
        int moving = ways[hedge.row][hedge.col];

        for (int i = 0; i < 4; i++) {
            int nRow = hedge.row + x[i];
            int nCol = hedge.col + y[i];

            if(nRow < 0 || nRow >= row || nCol < 0 || nCol >= col
                    || visited[nRow][nCol]) continue;

            if(!visited[nRow][nCol] && (map[nRow][nCol] == '.' || map[nRow][nCol] == 'D')){
                if(ways[nRow][nCol] == -1) return null;
                ways[nRow][nCol] = moving+1;
                if(map[nRow][nCol] == 'D') return new Coord(nRow, nCol);
                hedgeQ.add(new Coord(nRow, nCol));
            }
        }

        return null;
    }
}

class Coord{
    int row;
    int col;

    Coord(int row, int col){
        this.row = row;
        this.col = col;
    }
}