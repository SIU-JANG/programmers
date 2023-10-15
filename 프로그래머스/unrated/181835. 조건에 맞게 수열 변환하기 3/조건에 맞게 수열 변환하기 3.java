class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            if (k % 2 == 0) { // k 가 짝수
                answer[i] = arr[i] + k;
            } else { // k 가 홀수
                answer[i] = arr[i] * k;
            }
        }
        
        return answer;
    }
}