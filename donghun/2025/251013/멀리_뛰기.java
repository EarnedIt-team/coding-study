// 풀이 1 - 실패 (숫자 조합을 일일이 계산하려고 함)
// class Solution {
//     public long solution(int n) {
//         long answer = 0;
//         long num2 = 2;
    
        
//         // case 1: 1칸씩만 이동했을 때 (+1)
//         answer+=1;

//         // case 2: 2칸씩만 이동했을 때 (n%2)
//         if(n%2 == 0) answer+=1;
        
//         // case 3: 1과 2의 조합으로 구성된 경우
//         while(true) {
//             long num = n - num2;
            
//             if(num2 == 2) {
//                 answer = num + 1;
//                 num2*=2; // 2배 
//             } else {
//                 num 
//             }
            
            
//             // 나머지 자리는 1로 채움 (2, 1, 1 같이)
            
            
//         }
        
        
        
        
        
//         return answer;
//     }
// }

// 풀이 2 - 피보나치 수열 사용
class Solution {
    public long solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }
}