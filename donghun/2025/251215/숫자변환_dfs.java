// 풀이 1. 점수 50, 시간초과
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
        
        // dfs로 모든 방법 탐색?
        
        dfs(x, y, n, 0);
        
        return answer == 1_000_001 ? -1 : answer;
    }
    
    // 3가지 방법으로 계산해나가는 dfs
    // current (현재 상태), target (목표 자연수), cal(연산해야하는 값)
    // n(1번 방법), count(누적 count)
    private void dfs(int current, int target, int n, int count) {
        if(current == target) { // 목표값 도달 시, count 최솟값 기록
            answer = Math.min(answer, count);
        } else if (current < target){ // 아직 도달하지 못했을 때
            // 1번 방법
            dfs(current+n, target, n, count+1);
            // 2번 방법
            dfs(current*2, target, n, count+1);
            // 3번 방법
            dfs(current*3, target, n, count+1);
        }   
    }
}