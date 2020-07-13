package me.nyoung.BOJ.BFSDFS;

import java.util.*;

public class sol_2667 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] ch = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = ch[j]-'0';
            }
        }

        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        ArrayList<Integer> neigh = new ArrayList<>();
        int[] x = new int[]{0, 0, 1, -1};
        int[] y = new int[]{1, -1, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if(map[i][j] == 1){
                    rowQ.add(i);
                    colQ.add(j);
                    map[i][j] = 0;
                    count++;
                    while(rowQ.size() != 0){
                        int row = rowQ.poll();
                        int col = colQ.poll();

                        for (int k = 0; k < 4; k++) {
                            int nRow = row + y[k];
                            int nCol = col + x[k];

                            if(nRow < 0 || nRow >= map.length || nCol < 0 || nCol >= map[0].length) continue;

                            if(map[nRow][nCol] == 1){
                                rowQ.add(nRow);
                                colQ.add(nCol);
                                count++;
                                map[nRow][nCol] = 0;
                            }
                        }
                    }
                    neigh.add(count);
                }
            }
        }
        System.out.println(neigh.size());
        Collections.sort(neigh);
        for (int num: neigh) System.out.println(num);
    }
}
