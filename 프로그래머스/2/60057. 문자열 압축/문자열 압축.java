class Solution {
    
    static StringBuilder sb;
    
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            sb = new StringBuilder();
            String prev = "";
            int idx = 0;
            int count = 1;
            
            while (true) {
                if (prev.equals("")) {
                    idx += i;
                    prev = s.substring(0, idx);
                } else {
                    if (prev.equals(s.substring(idx, idx + i))) {
                        idx += i;
                        count++;
                    } else {
                        if (count == 1) {
                            sb.append(prev);
                            prev = s.substring(idx, idx + i);
                            idx += i;
                            count = 1;
                        } else if (count > 1) {
                            sb.append(count).append(prev);
                            prev = s.substring(idx, idx + i);
                            idx += i;
                            count = 1;
                        }
                    }
                }
                
                if (idx + i > s.length() - 1) {
                    if (prev.equals(s.substring(idx, s.length()))) {
                        count++;
                        sb.append(count).append(prev);
                    } else if (!prev.equals(s.substring(idx, s.length())) && count > 1) {
                        sb.append(count).append(prev).append(s.substring(idx, s.length()));
                    } else {
                        sb.append(prev).append(s.substring(idx, s.length()));
                    }
                    break;
                }
            }
                        
            answer = Math.min(answer, sb.toString().length());
        }
        
        return answer;
    }
}