package me.nyoung.BOJ.BackTracking;

public class sol_15650 {
    public void combination(boolean[] visited, int start, int r) {
        if (r == 0) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) System.out.print(i + 1 + " ");
            }
            System.out.println();
            return;
        }
        if (start >= visited.length) return;

        visited[start] = true;
        combination(visited, start + 1, r - 1);
        visited[start] = false;
        combination(visited, start + 1, r);
    }
}
