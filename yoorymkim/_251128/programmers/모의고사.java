package _251128.programmers;

import java.util.*;

public class 모의고사 {

    class Solution {
        public int[] solution(int[] answers) {
            // 1번 수포자 : 1, 2, 3, 4, 5 반복 -> 5
            // 2번 수포자 : 2, 1, 2, 3, 2, 4, 2, 5 반복 -> 8
            // 3번 수포자 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 반복 -> 10

            int[] supo1 = {1, 2, 3, 4, 5};
            int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int cnt1 = 0;
            int cnt2 = 0;
            int cnt3 = 0;

            for (int i = 0; i < answers.length; i++) {
                if (supo1[i % 5] == answers[i]) cnt1++;
                if (supo2[i % 8] == answers[i]) cnt2++;
                if (supo3[i % 10] == answers[i]) cnt3++;
            }


            int max = Math.max(cnt1, Math.max(cnt2, cnt3));

            ArrayList<Integer> list = new ArrayList<>();
            if (cnt1 == max) list.add(1);
            if (cnt2 == max) list.add(2);
            if (cnt3 == max) list.add(3);

            int[] answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {answer[i] = list.get(i);}

            return answer;
        }
    }
}
