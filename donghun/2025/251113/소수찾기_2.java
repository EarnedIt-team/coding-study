// 풀이 2. 성공 (제곱근 이용)

import java.util.*;

class Solution {
    public int solution(int n) {
        
        // count == 2 라면 소수임.
        int answer = 0;
        
        for(int num = 2; num <= n; num++) {
            int count = 0;
            
            for(int j = 1; j*j <= num; j++) {
                if(j*j == num) count++;
                else if(num % j == 0) count += 2;
                
                if(count > 2) break;
            }
            
            if(count == 2) answer++;
        }
        
        return answer;
    }
}