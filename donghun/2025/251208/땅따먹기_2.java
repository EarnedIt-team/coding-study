// 풀이 2. 테스트 케이스 통과, 제출 실패

import java.util.*;

class Solution {
    int solution(int[][] land) {
        
        // | 1 | 2 | 3 | 5 |
        // | 5 | 6 | 7 | 8 |
        // | 4 | 3 | 2 | 1 | 
        
        // 1개의 행씩 접근하며 가장 최댓값인 열의 인덱스값을 더해놓음
        // 해당 인덱스를 기억해두었다가 다음 행 접근
        
        // long[][] 상태
        // | 1 | 2 | 3 | 5 |
        // | 1+8 | 2+8 | 3+8 | 5+7 |
        // | 1+8+4 | 2+8+4 | 3+8+4 | 5+7+4 (정답) |
        
        int n = land.length;
        int m = land[0].length;
        
        int dp[][] = new int[n][m];
        
        // 1,2,3,5 첫행 저장해놓기
        for(int i = 0; i < m; i++) dp[0][i] = land[0][i];
         
        // 비교하면서 각 dp 배열에 누적합 계산
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int max = 0;    
                // 이번 행의 가장 큰값 저장
                for(int k = 0; k < m; k++) {
                    if(k != j) max = Math.max(max, land[i][k]);
                }
                // dp 배열 값 저장 (이전 행의 값과 이번 행의 값을 더하기)
                dp[i][j] = dp[i-1][j] + max;
            }
        }
        
        int answer = 0;
        // 맨 마지막 행의 값들을 비교하면 됨
        for(int i = 0; i < m; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }

        return answer;
    }
}