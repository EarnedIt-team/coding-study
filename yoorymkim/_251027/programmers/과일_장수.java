package _251027.programmers;

import java.util.*;

public class 과일_장수 {

    class Solution {
        public int solution(int k, int m, int[] score) {
            // 각 상자당 가격=그상자최하품*개수
            int answer = 0;
            Arrays.sort(score);

            int c = 0;
            int min = k+1;
            for(int i = score.length-1; i >= 0 ; i--) {
                c++;
                min = Math.min(min, score[i]);
                if (c == m) { // 개수 맞으면
                    answer += m * min;
                    c = 0;
                    min = k+1;
                }
            }
            return answer;
        }
    }
}
