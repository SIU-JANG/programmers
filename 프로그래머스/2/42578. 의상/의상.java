import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        for (int i = 0; i < clothes.length; i++) {
            if (map.get(clothes[i][1]) == null) {
                map.put(clothes[i][1], 1);
            } else {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
        }
        
        Iterator<String> itr = map.keySet().iterator();
        while (itr.hasNext()) {
            answer *= (map.get(itr.next()) + 1);
        }
        
        answer--;
        
        return answer;
    }
}