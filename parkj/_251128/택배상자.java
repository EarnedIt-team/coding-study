import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;   
        int nextBox = 1; // 다음에 오는 택배순서
        Stack<Integer> stack = new Stack<>();
        
        // order대로 물량 처리하기
        for (int item : order) {
            // order[i]가 나올 때까지 계속 보조 컨테이너에 추가
            while (nextBox <= order.length && 
                   (stack.isEmpty() || stack.peek() != item)) {
                stack.push(nextBox++); // 1, 2, 3, ...
            }
          
            // 보조 컨테이너 앞에 order[i]값 이라면 트럭에 실음
            if (!stack.isEmpty() && stack.peek() == item) {
                stack.pop();
                answer++;
            } else {
                break; // 더 이상 실을 수 없음
            }
        }
        
        return answer;
    }
}
