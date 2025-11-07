package _251107.programmers;

import java.util.*;

public class 기능개발 {

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            int[] days = new int[progresses.length]; // 매칭인덱스 작업의 각 소요일
            for(int i = 0; i < progresses.length; i++) {
                if ((100 - progresses[i]) % speeds[i] != 0) days[i]++;
                days[i] += (100 - progresses[i]) / speeds[i];
            }

            ArrayList<Integer> list = new ArrayList<>();

            // 5 ' 10 1 1 ' 20 20 1 '
            // 더 큰게 나오기 직전 or 끝값 직전에 와랄라 배포
            int prevDay = days[0];
            int count = 1;
            for(int i = 1; i < days.length; i++) {
                if (days[i] > prevDay) {
                    list.add(count);
                    prevDay = days[i];
                    count = 0;
                }
                count++;
            }

            list.add(count);

            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
            return arr;
        }
    }
}
