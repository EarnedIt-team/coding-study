// 풀이 3. 성공 (에라토스테네스의 체 이용)
import java.util.*;

class Solution {
    public int solution(int n) {
        // sieveOfEratosthenes()로 소수 여부 배열을 한 번만 계산
        boolean[] isPrime = sieveOfEratosthenes(n);

        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {  // false면 소수
                answer++;
            }
        }

        return answer;
    }

    // 에라토스테네스의 체 구현
    public boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1]; // false = 소수, true = 소수 아님

        // 0과 1은 소수가 아님
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true; // 배수는 소수 아님
                }
            }
        }

        return prime;
    }
}