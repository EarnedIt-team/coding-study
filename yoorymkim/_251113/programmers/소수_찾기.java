package _251113.programmers;

public class 소수_찾기 {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            for (int i = 2; i <= n; i++) { // 1은 소수 아님
                boolean isPrime = true;
                for(int j = 2; j*j <= i; j++){
                    if (i % j == 0) {
                        isPrime = false; // 나눠지면 소수 아님
                        break;
                    }
                }
                if (isPrime) answer++;
            }
            return answer;
        }
    }
}
