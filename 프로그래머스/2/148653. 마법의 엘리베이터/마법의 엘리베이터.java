import java.util.*;

class Solution {
    
    static int max_len = 0;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int storey) {        
        String s = Integer.toString(storey);
        max_len = s.length() + 1;
        
        recursive(storey, 0, 1);
        
        return answer;
    }
    
    public void recursive(int n, int c, int s) {
        if (Integer.toString(n).length() > max_len + 1) return;
        
        if (n <= 0) {
            answer = answer > c ? c : answer;
            return;
        }
        
        int a = (int)(n % Math.pow(10, s));
        
        recursive(n - a, c + (int)(a / Math.pow(10, s - 1)), s + 1);
        recursive(n + (int)(Math.pow(10, s) - a), c + (int)((Math.pow(10, s) - a) / Math.pow(10, s - 1)), s + 1);
    }
}