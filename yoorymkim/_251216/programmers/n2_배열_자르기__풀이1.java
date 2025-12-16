package _251216.programmers;

public class n2_배열_자르기__풀이1 {
    class Solution {
        public int[] solution(int n, long left, long right) {
            // 숫자가 겁나크다.
            // [left/n][left%n] ~ [right/n][right%n]
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    arr[i][j] = i+1;
                    arr[j][i] = i+1;
                }
                arr[i][i] = i+1;
            }

            int[] answer = new int[(int)(right - left + 1)];
            for (long i = left; i <= right; i++) {
                answer[(int)(i - left)] = arr[(int)(i / n)][(int)(i % n)];
            }
            return answer;
        }
    }
}
