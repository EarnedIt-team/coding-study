package _251208.programmers;

public class 땅따먹기_그리디_풀이 {
    class Solution {
        int solution(int[][] land) {
            // 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없 -> 완탐해...? 그리디 안될거같은데

            int answer = 0;
            int prevCol = -1;
            for (int[] row : land) {
                int valMax = 0;
                int idxMax = 0;
                for (int i = 0; i < row.length; i++) {
                    if(i != prevCol && row[i] > valMax) {
                        valMax= row[i];
                        idxMax = i;
                    }
                }
                answer += valMax;
                prevCol = idxMax;
            }

            return answer;
        }
    }
}
