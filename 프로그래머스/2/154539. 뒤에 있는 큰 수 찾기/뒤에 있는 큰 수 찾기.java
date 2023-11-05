import java.util.*;

class Solution {
    
    static Stack<Integer> s = new Stack<>();
    
    static int[] numbers;
    static int[] answer;
    
    public int[] solution(int[] numbers) {
        this.numbers = numbers;
        this.answer = new int[numbers.length];
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                answer[i] = -1;
            } else {
                while (!s.isEmpty()) {
                    int n = s.peek();
                    
                    if (n > numbers[i]) {
                        answer[i] = n;
                        break;
                    } else {
                        s.pop();
                    }
                    
                    if (s.isEmpty()) {
                        answer[i] = -1;
                    }
                }
            }
            
            s.add(numbers[i]);
        }
        
        return answer;
    }
}