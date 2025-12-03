package _251203.programmers;

public class 마법의_엘리베이터_풀이1 {
    class Solution {
        public int solution(int storey) {
            // -1, +1, -10, +10, -100, +100 등과 같이 절댓값이 10^c (c ≥ 0 인 정수) 형태인 정수들이 적힌 버튼
            // 현재 층 + 버튼에 적혀 있는 값 -> 이동 / 단, 계산값은 항상 >= 0 여야함
            // 0층으로 갈때, 버튼 누르는 횟수의 최소값 <= 자릿수마다 차이의 절대값 적은쪽으로 더하고빼며 이동하기 ?
            // 2764 -> 2760 -> 2800 -> 3000

            int zari = String.valueOf(storey).length(); // 자릿수
            int[] arr = new int[zari]; // 2764 => {4, 6, 7, 2}

            int idx = 0;
            while (storey > 0) {
                arr[idx++] = storey % 10;
                storey /= 10;
            }

            int answer = 0;
            for (int i = 0; i < zari-1; i++) {
                if (arr[i] <= 5) {
                    answer += arr[i];
                }
                else {
                    answer += 10 - arr[i];
                    arr[i+1] += 1;
                }
            }

            answer += arr[zari-1];

            return answer;
        }
    }
}
