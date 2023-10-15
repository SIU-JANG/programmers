import java.util.*;

class Solution {
    
    // 동생 토핑 수
    static Map<Integer, Integer> map_bro = new HashMap<>();
    // 철수의 토핑 수
    static Map<Integer, Integer> map_chul = new HashMap<>();
    
    public int solution(int[] topping) {
        int answer = 0;
        
        // 전체 토핑(처음 동생의 토핑)의 가지 수를 저장한다.
        for (int i = 0; i < topping.length; i++) {
            if (map_bro.get(topping[i]) == null) {
                map_bro.put(topping[i], 1);
            } else {
                map_bro.put(topping[i], map_bro.get(topping[i]) + 1);
            }
        }
        
        // 철수의 토핑을 하나씩 추가하면서 전체의 절반이 될 때, 경우의 수를 하나 추가한다.
        for (int i = 0; i < topping.length; i++) {
            if(map_chul.get(topping[i]) == null) {
                map_chul.put(topping[i], 1);
            } else {
                map_chul.put(topping[i], map_chul.get(topping[i]) + 1);
            }
            
            if (map_bro.get(topping[i]) > 1) {
                map_bro.put(topping[i], map_bro.get(topping[i]) - 1);
            } else {
                map_bro.remove(topping[i]);
            }
                        
            if (map_chul.size() == map_bro.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}