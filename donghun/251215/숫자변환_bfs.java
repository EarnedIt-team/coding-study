// 풀이 2. 점수 100, 성공
import java.util.*;

class Solution {
    int answer = 1_000_001;
    
    public int solution(int x, int y, int n) {
        
        // 제한 사항 (x,y 1,000,000)
        
        // 사용가능한 연산 종류 3가지
        // 1. x + n 
        // 2. x * 2
        // 3. x * 3
        // 이 3가지 방법을 이용하여 목표 점수로 도달하는
        // 최소 연산횟수를 리턴 (불가능하다면 -1)
        
        // 아 맞다 최단거리는 bfs였지 (queue)
        // 3가지 연산을 동시에 기록하면서 도달한 값이 있는 경우 종료하도록
        // [방법1, 방법2, 방법3, count]
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[1_000_001]; // +1 해줘야 1_000_000 까지 도달 가능;
        queue.add(new int[] {x, 0});
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int value = poll[0];
            int count = poll[1];
            
            if(value == y) return count;
            
            // 3가지 연산 수행
            int[] cal_values = new int[]{value+n, value*2, value*3};
            
            for(int i = 0; i < 3; i++) {
                int pick = cal_values[i];
                
                if(pick <= y && !visited[pick]) {
                    queue.add(new int[]{pick, count+1});
                    visited[pick] = true; // 방문 처리
                }
            }
        }
        
        return -1;
    }
}