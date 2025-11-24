package _251124.programmers;

public class 타겟_넘버_풀이3 {
    class Solution {
        public int solution(int[] numbers, int target) {
            // +4+1-2+1 = 4 / +4-1+2-1 = 4 -> 숫자 순서 고정, 안에 + , - 기호 어떻게 넣느냐의 문제
            // 끝까지 탐색해서 맞는 모든 경우의 수 -> 깊우탐 .. 근데 꼭 탐색로직이 필요할까

            int len = numbers.length;
            int total = 1 << len;  // 모든 경우의 수 : 2^len

            int answer = 0;
            for (int mask = 0; mask < total; mask++) { // 바로 비트마스크로~ (이전 반복문세트 2개 합친ver)
                int sum = 0;
                for (int bit = 0; bit < len; bit++) {
                    if ((mask & (1 << bit)) != 0) sum += numbers[len - 1 - bit];
                    else sum -= numbers[len - 1 - bit];
                }
                if (sum == target) answer++;
            }

            return answer;
        }
    }

}
