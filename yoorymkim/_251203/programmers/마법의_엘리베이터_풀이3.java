package _251203.programmers;

public class 마법의_엘리베이터_풀이3 {
    class Solution {
        public int solution(int storey) {
            // -1, +1, -10, +10, -100, +100 등과 같이 절댓값이 10^c (c ≥ 0 인 정수) 형태인 정수들이 적힌 버튼
            // 현재 층 + 버튼에 적혀 있는 값 -> 이동 / 단, 계산값은 항상 >= 0 여야함
            // 0층으로 갈때, 버튼 누르는 횟수의 최소값 <= 자릿수마다 차이의 절대값 적은쪽으로 더하고빼며 이동하기 ?
            // 2764 -> 2760 -> 2800 -> 3000 / 45 -> 40 -> 0 : 9 / 45 -> 50 -> 0 : 10

            // 배열의 경우 999 처리 못함 (1000됨 !!!)

            int answer = 0;

            while (storey > 0) {
                int n = storey % 10;
                int next = (storey / 10) % 10;

                if (n < 5) {
                    answer += n;
                    storey /= 10;
                }
                else if (n > 5) {
                    answer += 10 - n;
                    storey = (storey / 10) + 1;
                }
                else { // 5인 경우
                    if (next >= 5) {
                        answer += 5;
                        storey = (storey / 10) + 1;
                    } else {
                        answer += 5;
                        storey /= 10;
                    }
                }
            }

            return answer;
        }
    }

}
