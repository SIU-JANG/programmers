import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        for (int i = 0; i < completion.length; i++) {
            if (map.get(completion[i]) == null) {
                map.put(completion[i], 1);
            } else {
                map.put(completion[i], map.get(completion[i]) + 1);
            }
        }
        
        for (int i = 0 ; i < participant.length; i++) {
            if (map.get(participant[i]) == null) {
                return participant[i];
            } else if (map.get(participant[i]) > 0) {
                map.put(participant[i], map.get(participant[i]) - 1);
            } else {
                return participant[i];
            }
        }
        
        return answer;
    }
}