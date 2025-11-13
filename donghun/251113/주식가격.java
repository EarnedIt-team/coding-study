import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 문제에 스택/큐라고 써있네 ㅎㅎ
        
        // 정답 배열
        int[] answer = new int[prices.length];
        
        // prices 값을 하나씩 접근
        for(int i = 0; i < prices.length; i++) {
            int current = prices[i];
            // System.out.println("current" + current);
            int count = 0;
            
            // 꺼낸 인덱스부터 그 이후 값들을 비교
            for(int j = i+1; j < prices.length; j++) {
                int peek = prices[j];
                // System.out.println("peek" + peek);
                count++;
                
                // 비교했을 때 현재값보다 꺼낸 값이 크다면
                if(current <= peek) {
                    continue;
                } else { // 더 작다면
                    answer[i] = count;
                    break;
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
}