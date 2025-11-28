import java.util.*;

class Solution {
    public int solution(int[] order) {

        // 보조 컨테이너 벨트는 스택형
        Stack<Integer> stack = new Stack<>();
        
        int answer = 0;
    
        int current_box = 0;
        for(int i = 1; i <= order.length; i++) {
            // 보조 컨테이너 벨트에 일단 삽입 1,, 2,, 3,,
            stack.push(i); 
            // System.out.println("영재가 " + (i) + "상자를 보조 컨테이너에 올립니다.");
            
            // 스택 검사
            while(!stack.isEmpty() && stack.peek() == order[current_box]) {
                // System.out.println("보조컨테이너에서" + order[current_box] + "를 꺼내고 트럭에 싣습니다.");
                stack.pop();
                current_box++;
                answer++;
            }
        }
        
        
        
        return answer;
    }
}