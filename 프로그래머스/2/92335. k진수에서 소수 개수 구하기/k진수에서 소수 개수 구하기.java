import java.util.*;

class Solution {    
    public int solution(int n, int k) {        
        int answer = 0;
        
        String kn = convert(n, k);
        String[] arr = kn.split("0");
                        
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (s.equals("")) continue;
            
            if (isPrimeNumber(Long.parseLong(s))) {
                answer++;
            }
        }
                
        return answer;
    }
    
    public String convert(int n, int k) {
        String ret = "";
        
        while (n > 0) {
            int temp = n % k;
            ret += Integer.toString(temp);
            n /= k;
        }
        
        StringBuffer sb = new StringBuffer(ret);
        String reverse = sb.reverse().toString();
        
        return reverse;
    }
    
    public boolean isPrimeNumber(long n) {
        if (n < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}