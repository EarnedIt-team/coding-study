import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 모든 음식의 스코빌 지수를 K 이상으로 만들기
        // 섞은 음식 = 가장 낮은 음식 + (두 번째로 낮은 음식 * 2)
        // 섞은 음식은 "K 이상"이 될 때까지 반복
        // 모든 음식이 K가 되기위해 섞어야하는 최소 횟수
        
        int answer = 0;
        // 우선 순위 Queue
        // 기본형 : 우선 순위가 "낮은" 순서대로 FIFO, PriorityQueue<>();
        // 리버스 : 우선 순위가 "높은" 순서대로 FIFO, PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> foodScoville = new PriorityQueue<>();
        
        // heap에 스코빌 지수 추가
        for (int score : scoville) {
            foodScoville.offer(score);
        }
        
        while(foodScoville.peek() < K) {
            // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
            if (foodScoville.size() == 1) return -1;
            
            int min = foodScoville.poll(); // 최소값 가져오기
            int min2 = foodScoville.poll(); // 두번째 최소값 가져오기 
            
            foodScoville.offer(min + (min2 * 2)); // 음식 섞기
            answer++;
        }
        
        return answer;
    }
}
