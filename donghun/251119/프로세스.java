import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // A,B,C,D [2,1,3,2] 
        // B,C,D,A [1,3,2,2] 
        // C,D,A,B [3,2,2,1] 
        // D,A,B [2,2,1] -> C 
        // A,B [2,1] -> D
        // B [1] -> A
        // [] -> B 
        
        // 삽입할 큐 선언
        Queue<int[]> queue = new LinkedList<>();
        
        // 꺼낸 순서 카운팅
        int count = 0;
        
        // 큐에 순서대로 삽입
        for(int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
        }
        
        // queue의 원소들을 조건에 맞게 제거
        while(!queue.isEmpty()) {
            // 꺼낸 값의 우선 순위 확인
            int[] peek = queue.peek();
            
            // 더 높은 우선순위가 있는지 체크하는 변수
            boolean check = false;
            
            // 큐에서 꺼낸 값보다 높은 우선순위가 있는지 검사
            for (int[] item : queue) {
                if (item[0] > peek[0]) {
                    check = true;
                    break;
                }
            }
 
            // 만약 더 높은 우선 순위가 있다면 꺼낸 후 다시 queue에 삽입
            if(check) {
                queue.poll(); // 꺼내고 
                queue.add(peek); // 다시 넣기
            } 
            // 꺼낸 값이 가장 우선순위가 높다면 그대로 실행(동시에 꺼낸 횟수 카운팅)
            else {
                queue.poll(); // 꺼내고
                count++; // 꺼낸 순서 카운트
                
                // 꺼낸 값이 해당 인덱스랑 일치하는지 확인
                if(peek[1] == location) {
                    return count;
                }
            }
        }
        return -1;
    }
}