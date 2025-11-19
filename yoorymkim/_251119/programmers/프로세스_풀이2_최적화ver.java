package _251119.programmers;

import java.util.*;

public class 프로세스_풀이2_최적화ver {

    class Solution {

        public int solution(int[] priorities, int location) {

            Queue<Integer> q = new LinkedList<>(); // ind 넣기
            int[] count = new int[10]; // ind:priority, val:개수

            for (int i = 0; i < priorities.length; i++) {
                q.offer(i);
                count[priorities[i]]++;
            }

            int answer = 0;

            while (!q.isEmpty()) {
                int i = q.poll();
                int p = priorities[i];

                if (isThereHigherPriorityFast(p, count)) {
                    q.offer(i);
                } else {
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
