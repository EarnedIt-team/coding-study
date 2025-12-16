package _251216.programmers;

public class n2_배열_자르기__풀이2 {
    class Solution {
        public int[] solution(int n, long left, long right) {
            // 숫자가 겁나크다.
            // [left/n][left%n] ~ [right/n][right%n]

            // 12345 22345 33345 44445 55555 / n = 5
            // 01234 56789 ... == i
            // 11111 22222 33333 44444 55555 == i/n + 1
            // 12345 12345 12345 12345 12345 == i%n + 1
            // 숫자 = max (i/n+1, i/n+1)

            int[] answer = new int[(int)(right - left + 1)];
            for (long i = left; i <= right; i++) {
                answer[(int)(i - left)] = Math.max((int)(i%n)+1, (int)(i/n)+1);
            }
            return answer;
        }
    }
}
