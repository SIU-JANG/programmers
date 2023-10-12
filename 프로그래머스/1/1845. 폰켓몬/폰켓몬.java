import java.util.*;

class Solution {
    
    static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[] nums) {
        int answer = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        
        answer = map.size() >= nums.length / 2 ? nums.length / 2 : map.size();
        
        return answer;
    }
}