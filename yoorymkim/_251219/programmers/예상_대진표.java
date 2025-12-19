package _251219.programmers;

public class 예상_대진표 {
    class Solution {
        public int solution(int n, int a, int b) {
            // 2^5 -> 2^4 -> 2^3 ... 식으로 반절씩 날림
            // a -> a/2 or a/2+1 (각각 a가 짝/홀수일때)

            int answer = 1;
            while (n >= 2) {
                if (a < b && a%2 == 1 && b-a == 1) return answer;
                else if (b < a && b%2 == 1 && a-b == 1) return answer;

                n /= 2;

                if (a%2 == 1) a = a/2 + 1;
                else a = a/2;

                if (b%2 == 1) b = b/2 + 1;
                else b = b/2;

                answer++;
            }

            return answer;
        }
    }
}
