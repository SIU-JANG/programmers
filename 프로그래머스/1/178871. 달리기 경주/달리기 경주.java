import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            int idx1 = map.get(callings[i]);
            int idx2 = idx1 - 1;
            
            swap(players, idx1, idx2);
        }
        
        answer = players;
        
        return answer;
    }
    
    static void swap(String[] players, int idx1, int idx2) {
        map.put(players[idx1], idx1 - 1);
        map.put(players[idx2], idx2 + 1);
        
        String temp = players[idx1];
        players[idx1] = players[idx2];
        players[idx2] = temp;
    }
}