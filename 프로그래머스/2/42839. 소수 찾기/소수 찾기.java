import java.util.*;

class Solution {
    
    static int[] src;
    static int[] tgt;
    static boolean[] select;
    
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        src = new int[numbers.length()];
        select = new boolean[numbers.length()];
        
        for (int i = 0; i < numbers.length(); i++) {
            src[i] = numbers.charAt(i) - '0';
        }
        
        for (int i = 1; i <= numbers.length(); i++) {
            Arrays.fill(select, false);
            tgt = new int[i];
            
            perm(0);
        }
        
        answer = set.size();
        
        return answer;
    }
    
    public void perm(int tgtIdx) {
        if (tgtIdx == tgt.length) {
            String nStr = "";
            for (int i = 0; i < tgt.length; i++) {
                nStr += Integer.toString(tgt[i]);
            }
            
            int n = Integer.parseInt(nStr);
            
            if (n >= 2 && isPrimeNumber(n)) {
                set.add(n);
            }
            
            return;
        }
        
        for (int i = 0; i < src.length; i++) {
            if (select[i]) continue;
            
            select[i] = true;
            tgt[tgtIdx] = src[i];
            perm(tgtIdx + 1);
            select[i] = false;
        }
    }
    
    public boolean isPrimeNumber(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}