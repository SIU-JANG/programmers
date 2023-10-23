import java.util.*;

class Solution {
    
    static int[] dp = new int[1000001];
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        if (x == y) return 0;
        
        dp[x] = 1;
        for (int i = x + 1; i <= y; i++) {
            if (i - n >= 0 && dp[i - n] > 0) {
                dp[i] = dp[i - n] + 1;
            }
            
            if (i % 2 == 0 && i / 2 > 0 && dp[i / 2] > 0) {
                if (dp[i] > 0) {
                    dp[i] = Math.min(dp[i], dp[i / 2] + 1);   
                } else {
                    dp[i] = dp[i / 2] + 1;
                }
            }
            
            if (i % 3 == 0 && i / 3 > 0 && dp[i / 3] > 0) {
                if (dp[i] > 0) {
                    dp[i] = Math.min(dp[i], dp[i / 3] + 1);   
                } else {
                    dp[i] = dp[i / 3] + 1;
                }
            }
        }
        
        answer = dp[y] - 1;
                
        return answer;
    }
}