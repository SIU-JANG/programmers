class Solution {
    
    static int[] picks;
    static String[] minerals;
    static int answer = Integer.MAX_VALUE;
    
    static int[][] table = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    
    public int solution(int[] picks, String[] minerals) {
        
        this.picks = picks;
        this.minerals = minerals;
        
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            if (picks[i] > 0) {
                picks[i]--;
                
                // calc sum
                for (int j = 0; j < 5; j++) {
                    if (minerals[j].equals("diamond")) {
                        sum += table[i][0];
                    } else if (minerals[j].equals("iron")) {
                        sum += table[i][1];
                    } else {
                        sum += table[i][2];
                    }
                }
                
                dfs(sum, 5);
                picks[i]++;
            }
        }
        
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        
        return answer;
    }
    
    static void dfs(int s, int startIdx) {
        boolean pickIsEmpty = true;
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                pickIsEmpty = false;
                break;
            }
        }
        
        if (pickIsEmpty || startIdx >= minerals.length) {
            answer = answer > s ? s : answer;
                        
            return;
        }
        
        int endIdx = Math.min(startIdx + 5, minerals.length);
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                
                // calc sum
                int c = 0;
                for (int j = startIdx; j < endIdx; j++) {
                    if (minerals[j].equals("diamond")) {
                        c += table[i][0];
                    } else if (minerals[j].equals("iron")) {
                        c += table[i][1];
                    } else if (minerals[j].equals("stone")) {
                        c += table[i][2];
                    }
                }
                                
                dfs(s + c, endIdx);
                picks[i]++;
            }
        }
    }
}