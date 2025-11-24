package _251124.programmers;

public class 타겟_넘버_풀이1 {
    class Solution {
        public int solution(int[] numbers, int target) {
            // +4+1-2+1 = 4 / +4-1+2-1 = 4 -> 숫자 순서 고정, 안에 + , - 기호 어떻게 넣느냐의 문제
            // 끝까지 탐색해서 맞는 모든 경우의 수 -> 깊우탐 .. 근데 꼭 탐색로직이 필요할까

            int len = numbers.length;

            int total = 1 << len;  // 모든 경우의 수 : 2^len
            char[][] PlusMinus = new char[total][len]; // {{+,+,+},{+,+,-} ...}

            for (int i = 0; i < total; i++) {
                for (int bit = 0; bit < len; bit++) {
                    // i를 2진수로 봤을 때, bit번째 자리가 1이면 true / 0이면 false
                    if ((i & (1 << bit)) != 0) PlusMinus[i][len-1-bit] = '+';
                    else PlusMinus[i][len-1-bit] = '-';
                }
            }

            int answer = 0;

            for (int i = 0; i < total; i++) {
                int sum = 0;
                for (int j = 0; j < len; j++) {
                    if (PlusMinus[i][j] == '+') sum += numbers[j];
                    else sum -= numbers[j];
                }
                if (sum == target) answer++;
            }

            return answer;
        }
    }
}
