import java.util.*;

class Solution {
    
    static Queue<Truck> q = new ArrayDeque<>();
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bw = 0;
        int idx = 0;
        
        while (true) {
            answer++;
            
            if (!q.isEmpty() && q.peek().dist <= 0) {
                bw -= q.peek().weight;
                q.poll();
            }
            
            if (idx >= truck_weights.length && q.isEmpty()) {
                break;
            }
            
            if (idx < truck_weights.length && bw + truck_weights[idx] <= weight) {
                Truck t = new Truck(truck_weights[idx++], bridge_length);
                q.add(t);
                bw += t.weight;
            }
            
            int currentSize = q.size();
            for (int i = 0; i < currentSize; i++) {
                Truck t = q.poll();
                t.dist--;
                q.add(t);
            }
        }
        
        return answer;
    }
}

class Truck {
    int weight;
    int dist;
    
    public Truck(int weight, int dist) {
        this.weight = weight;
        this.dist = dist;
    }
}