package _251119.programmers;

import java.util.*;

public class 프로세스_풀이1 {

    class Solution {

        HashMap<Integer, Integer> map; // key : ind, val : priority

        public int solution(int[] priorities, int location) {
            // [1, 1, 9, 1, 1, 1] 이므로 [C, D, E, F, A, B] 순
            // 숫자가 클 수록 우선순위가 높다

            map = new HashMap<>();
            Queue<Integer> q = new LinkedList<>(); // ind 넣기

            for (int i = 0; i < priorities.length; i++) {
                map.put(i, priorities[i]);
                q.offer(i);
            }

            int answer = 0;
            while (!q.isEmpty()) { // 조건은 이러하나 location 실행시 break(효율)
                int i = q.poll();
                int p = map.get(i);

                if (isThereHigherPriority(p)) q.offer(i);
                else {
                    map.remove(i);
                    answer++;
                    if (i == location) return answer;
                }
            }

            return answer;
        }

        private boolean isThereHigherPriority(int x) {
            for (int v : map.values()) {
                if (v > x) return true;
            }
            return false;
        }
    }
}
