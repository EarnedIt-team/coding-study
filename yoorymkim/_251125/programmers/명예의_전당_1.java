package _251125.programmers;

import java.util.*;

public class 명예의_전당_1 {

    class Solution {
        public int[] solution(int k, int[] score) {
            int len = score.length;
            int[] answer = new int[len];
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                list.add(score[i]);
                Collections.sort(list);
                if (list.size() > k) list.remove(0);

                answer[i] = list.get(0);
            }

            return answer;
        }
    }
}
