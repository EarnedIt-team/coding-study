import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 이거 완전 dp 아닌가? 아님 말고 -> 아니라네
        
        //낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int count = 0;
        while(pq.size() > 1) {
            if(pq.peek() >= K) return count;
            
            // 가장 맵지 않은 음식 스코빌 + (두번째 맵지 않은 음식 스코빌 * 2)
            if(pq.size() >= 2) {
                int addValue = pq.poll() + (pq.poll()*2);
                pq.add(addValue);    
                count++;
            }
            
        }
        
        return pq.peek() >= K ? count : -1;
    }
}