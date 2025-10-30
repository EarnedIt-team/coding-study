package _251030.programmers;

public class 카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            // Math.sqrt(x) : x 제곱근 9->3

            int total = brown + yellow;
            int[] sol = new int[2];

            for (int h = 3; h <= Math.sqrt(total); h++) {
                if (total % h == 0) { // 직사각형 모양일때만 가능(나머지x) -> 타일이 남지않을때만 가능
                    int w = total / h;

                    if ((w - 2) * (h - 2) == yellow) {
                        sol[0] = w;
                        sol[1] = h;
                    }
                }
            }
            return sol;
        }
    }
}
