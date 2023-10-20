import java.util.*;

class Solution {
    
    static int n;
    static int[][] wires;
    static int answer = Integer.MAX_VALUE;
    
    static boolean[][] graph;
    
    static Queue<Integer> q = new ArrayDeque<>();
    static boolean[] checked;
    
    public int solution(int n, int[][] wires) {
        this.n = n;
        this.wires = wires;
        
        graph = new boolean[n + 1][n + 1];
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a][b] = true;
            graph[b][a] = true;
        }
        
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a][b] = false;
            graph[b][a] = false;
            
            checked = new boolean[n + 1];
            bfs();
            
            graph[a][b] = true;
            graph[b][a] = true;
        }
        
        return answer;
    }
    
    static void bfs() {
        int count = 0;
        
        q.add(1);
        checked[1] = true;
        
        while(!q.isEmpty()) {
            int m = q.poll();
            
            for (int i = 1; i < graph[m].length; i++) {
                if (graph[m][i] && !checked[i]) {
                    checked[i] = true;
                    q.add(i);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (checked[i]) {
                count++;
            }
        }
        
        answer = answer > Math.abs(Math.abs(n-count) - count) ? Math.abs(Math.abs(n - count) - count) : answer;
    }
}