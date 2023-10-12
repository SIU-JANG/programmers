class Solution {
    
    static int[][] arr;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        arr = new int[n + 1][n + 1];
        for (int i = 0; i < results.length; i++) {
            int x = results[i][0];
            int y = results[i][1];
            
            arr[x][y] = 1;  // 승리
            arr[y][x] = -1; // 패배
        }
        
        //플로이드-워셜 알고리즘
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                        arr[j][i] = -1;
                    } else if (arr[i][k] == -1 && arr[k][j] == -1) {
                        arr[i][j] = -1;
                        arr[j][i] = 1;
                    }
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] != 0) {
                    count++;
                }
            }
            
            if (count == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}