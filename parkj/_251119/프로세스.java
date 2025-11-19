import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>(); 
        int answer = 0;
        
        // 배열로 되어있는 우선순위를 Queue에 저장 (+ 순서를 함께 기억)
        int index = 0;
        for(int num : priorities) queue.add(new int[]{priorities[index], index++});

        while (!queue.isEmpty()) {
            int[] process = queue.poll(); // Queue에서 값을 꺼내옴

            // 더 높은 우선순위가 큐에 존재하는가?
            boolean isPriority = queue.stream()
                                      .anyMatch(waitingProcess -> 
                                                waitingProcess[0] > process[0]);
            
            // 큐에 높은 우선순위 프로세스가 존재한다면,
            if (isPriority) {
                queue.add(process); // 다시 큐에 넣음
            // 현재 프로세스가 우선순위가 높다면,
            } else {
                answer++; // 일단 프로세스를 실행했다고 가정
                // "정해진 프로세스가 맞는지" 검증
                // 우선순위가 동일한 프로세스가 존재하기에, 순서를 기억한 location을 사용
                // [1,1,9,1,1,1]
                if (process[1] == location) break;   
            }
        }

        return answer;
    }
}
