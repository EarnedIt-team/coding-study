package _251104.programmers;

public class 최소직사각형 {
    class Solution {
        public int solution(int[][] sizes) {
            // 가로가 더 길게 일단 전체카드 돌리기
            // 가로최대*세로최대

            int maxG = 0; // 가로최대
            int maxS = 0; // 세로최대

            for (int[] card : sizes) {
                if (card[0] < card[1]) {
                    int temp = card[0];
                    card[0] = card[1];
                    card[1] = temp;
                }
                maxG = Math.max(card[0], maxG);
                maxS = Math.max(card[1], maxS);
            }

            return maxG*maxS;
        }
    }
}
