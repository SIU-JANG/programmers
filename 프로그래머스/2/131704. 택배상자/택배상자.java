import java.util.*;

class Solution {
    
    static int[] order;
    static boolean[] checked;
    static int answer = 0;
    static int n = 1;
    static Stack<Integer> s = new Stack<>();
    
    public int solution(int[] order) {
        this.order = order;
        checked = new boolean[order.length + 1];
        
        for (int i = 0; i < order.length; i++) {
            if (order[i] == n) {
                answer++;
                n = order[i];
                checked[order[i]] = true;
            } else if (order[i] > n) {
                for (int j = n; j < order[i]; j++) {
                    if (!checked[j]) {
                        s.add(j);
                        checked[j] = true;
                    }
                }
                
                checked[order[i]] = true;
                n = order[i];
                answer++;
            } else {
                int p = s.pop();
                
                if (p == order[i]) {
                    answer++;
                    checked[order[i]] = true;
                    n = order[i];
                } else {
                    break;
                }
            }
        }
        
        return answer;
    }
}