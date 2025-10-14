// 풀이 1 - 실패
// class Solution {
//     public int[] solution(int n, int m) {
        
//         int[] answer = new int[2];
        
//         // 최대 공약수 구하기
//         if(n < m && m % n == 0) {
//             answer[0] = n;
//             answer[1] = m;
//         } else if(m > n && n % m == 0) {
//             answer[0] = m;
//             answer[1] = n;
//         } else {
//             answer[0] = 1;
//             answer[1] = m*n;
//         }
        
//         return answer;
//     }
// }

// 풀이 2 - 성공
import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int small = Math.min(n, m);
        int big = Math.max(n, m);
        
        int gcd = getGCD(big, small);
        int lcm = (n * m) / gcd;
        
        answer[0] = gcd;
        answer[1] = lcm;
        
        return answer;
    }
    
    // 유클리드 호제법
    int getGCD (int x, int y) {
        if(y == 0) return x;
        return getGCD(y, x % y);
    }
}

