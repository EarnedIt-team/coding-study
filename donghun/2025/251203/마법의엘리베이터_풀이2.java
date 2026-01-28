import java.util.*;

class Solution {
    public int solution(int storey) {
        // 0층으로 내려가려면 최소 몇개의 마법의 돌이 필요한지 리턴하는 문제
        
        int answer = 0;
        while(storey > 0) {
            int cur = storey % 10;
            int front = (storey/10) % 10;
            
            if(cur < 5) {
                answer+=cur;
            } else if(cur > 5) {
                answer+=(10-cur);
                storey+=(10-cur);
            } else { // cur == 5
                if(front < 5) {
                    answer+=cur;
                } else { // front > 5
                    answer+=(10-cur);
                    storey+=(10-cur);
                }
            }
            
            storey /= 10; // 1의 자리 제거
        }
        
        return answer;
    }
}