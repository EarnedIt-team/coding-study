package _251119.programmers;

import java.util.*;

public class 프로세스_풀이2_최적화ver {

    class Solution {

        public int solution(int[] priorities, int location) {
            // [1, 1, 9, 1, 1, 1] 이므로 [C, D, E, F, A, B] 순
            // 숫자가 클 수록 우선순위가 높다

            HashMap<Integer, Integer> map = new HashMap<>(); // key:ind, val:priority
            Queue<Integer> q = new LinkedList<>(); // ind 넣기

            int[] count = new int[10]; // ind:priority, val:개수

            for (int i = 0; i < priorities.length; i++) {
                map.put(i, priorities[i]);
                q.offer(i);
                count[priorities[i]]++; // 등장 횟수 증가
            }

            int answer = 0;
            while (!q.isEmpty()) {
                int i = q.poll();
                int p = map.get(i);

                if (isThereHigherPriorityFast(p, count)) q.offer(i);
                else {
                    map.remove(i);
                    count[p]--;
                    answer++;
                    if (i == location) return answer;
                }
            }

            return answer;
        }

        private boolean isThereHigherPriorityFast(int x, int[] count) {
            for (int p = x + 1; p <= 9; p++) {
                if (count[p] > 0) return true;
            }
            return false;
        }
    }
}
