package me.nyoung.BOJ.BackTracking;

public class sol_15649 {
    public void perm(int[] arr, boolean[] visited, int start, int n, int r){
        if(start == r){
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            arr[start] = i+1;
            perm(arr, visited ,start+1, n, r);
            visited[i] = false;
        }
    }
}
