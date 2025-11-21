package _251121.programmers;

public class 뒤에_있는_큰_수_찾기_풀이1 {

    class Solution {
        public int[] solution(int[] numbers) {
            // 자신보다 뒤에 있는 숫자 + 자신보다 큼 + 가장 가까이 있는 수
            int len = numbers.length;

            for (int i = 0; i < len-1; i++) {
                for (int j = i+1; j < len; j++) {
                    if (numbers[j] > numbers[i]) {
                        numbers[i] = numbers[j];
                        break;
                    }
                    if (j == len-1) numbers[i] = -1;
                }
            }

            numbers[len-1] = -1;
            return numbers;
        }
    }
}
