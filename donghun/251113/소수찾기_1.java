// 풀이 1. 실패 (시간 초과) / 무지성 박치기 버전
class Solution {
    public int solution(int n) {
        
        // count == 2 라면 소수임.
        int answer = 0;
        
        for(int i = 2; i <= n; i++) {
            int count = 0;
            
            for(int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    count++;
                }
                if(count > 2) break; 
            }
            
            if(count == 2) answer++;
        }
        return answer;
    }
}