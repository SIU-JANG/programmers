import java.util.*;

class Solution {
    
    static char[] src;
    static char[] tgt;
    static boolean[] select;
    
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        src = new char[numbers.length()];
        select = new boolean[src.length];
        for (int i = 0; i < numbers.length(); i++) {
            src[i] = numbers.charAt(i);
        }
        
        for (int i = 1; i <= numbers.length(); i++) {
            tgt = new char[i];
            
            perm(0);
        }
        
        answer = set.size();
        
        return answer;
    }
    
    public void perm(int tgtIdx) {
        if (tgtIdx == tgt.length) {
            findPrime();
            
            return;
        }
        
        for (int i = 0; i < src.length; i++) {
            if (select[i]) {
                continue;
            }
            
            tgt[tgtIdx] = src[i];
            select[i] = true;
            perm(tgtIdx + 1);
            select[i] = false;
        }
    }
    
    public void findPrime() {
        String s = "";
        for (int i = 0; i < tgt.length; i++) {
            s += tgt[i];
        }
        
        int n = Integer.parseInt(s);
        
        if (isPrime(n) && n >= 2) {
            set.add(n);
        }
    }
    
    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}