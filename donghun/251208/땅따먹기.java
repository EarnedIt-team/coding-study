import java.util.*;

class Solution {
    int solution(int[][] land) {    
        int n = land.length;
        int m = land[0].length;
        
        int dp[][] = new int[n][m];
        
        // 1,2,3,5 첫행 저장해놓기
        for(int i = 0; i < m; i++) dp[0][i] = land[0][i];
         
        // 비교하면서 각 dp 배열에 누적합 계산
        for(int i = 1; i < n; i++) { // i = 1, j = 1
            for(int j = 0; j < m; j++) {
                int max = 0;    
                // 이전 행의 가장 큰값 저장
                for(int k = 0; k < m; k++) {
                    if(k != j) max = Math.max(max, dp[i-1][k]);
                }
                // dp 배열 값 저장 (이전 행의 값과 이번 행의 값을 더하기)
                dp[i][j] = land[i][j] + max;
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