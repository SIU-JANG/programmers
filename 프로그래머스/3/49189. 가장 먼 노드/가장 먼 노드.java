import java.util.*;

class Solution {
    
    static List<List<Edge>> vertex = new ArrayList<>();
    static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
    static boolean[] checked;
    static int[] cost;
    
    static int n;
    static int answer;
    
    public int solution(int n, int[][] edge) {
        this.answer = 0;
        this.n = n;
        checked = new boolean[n + 1];
        cost = new int[n + 1];
        
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = 0;
        pq.add(new Edge(1, 0));
        
        for (int i = 0; i <= n; i++) {
            vertex.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            
            vertex.get(x).add(new Edge(y, 1));
            vertex.get(y).add(new Edge(x, 1));
        }
        
        dijkstra();
        
        int d = 0;
        for (int i = 1; i <= n; i++) {
            d = d < cost[i] && cost[i] != Integer.MAX_VALUE ? cost[i] : d;
        }
        
        for (int i = 1; i <= n; i++) {
            if (cost[i] == d) answer++;
        }
        
        return answer;
    }
    
    static void dijkstra() {        
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            
            if (checked[e.u] || cost[e.u] < e.c) continue;
            
            checked[e.u] = true;
            
            for (Edge ne : vertex.get(e.u)) {
                if (!checked[ne.u] && cost[ne.u] > cost[e.u] + ne.c) {
                    cost[ne.u] = cost[e.u] + ne.c;
                    pq.add(new Edge(ne.u, cost[ne.u]));
                }
            }
        }
    }
}

class Edge {
    int u;
    int c;
    
    public Edge(int u, int c) {
        this.u = u;
        this.c = c;
    }
}