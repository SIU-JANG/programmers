class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int[][] dp = new int[land.length][land[0].length];
        for (int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }
        
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int max_value = 0;
                for (int k = 0; k < land[i].length; k++) {
                    if (j == k) continue;
                    
                    max_value = max_value < dp[i - 1][k] ? dp[i - 1][k] : max_value;
                }
                
                dp[i][j] = land[i][j] + max_value;
            }
        }
        
        for (int i = 0; i < land[land.length - 1].length; i++) {
            answer = answer < dp[dp.length - 1][i] ? dp[dp.length - 1][i] : answer;
        }

        return answer;
    }
}