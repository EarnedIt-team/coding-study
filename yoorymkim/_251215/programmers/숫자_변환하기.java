package _251215.programmers;

import java.util.*;

public class 숫자_변환하기 {

    class Solution {
        public int solution(int x, int y, int n) {
            // 전체 경우의 수가 무한 .. 완탐불가. 넓이탐색 ???? 그리디? dp???
            // 다 증가하는 연산이면 그리디 가능아님???? 예외가 없을거같은데??? -> 아니다 예외가 백퍼 있을듯
            boolean[] visited = new boolean[y + 1];
            Queue<Integer> queue = new LinkedList<>();

            queue.offer(x);
            visited[x] = true;

            int answer = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();

                    if (cur == y) return answer;

                    int[] nexts = {cur + n, cur * 2, cur * 3};
                    for (int ne : nexts) {
                        if (ne <= y && !visited[ne]) {
                            visited[ne] = true;
                            queue.offer(ne);
                        }
                    }
                }
                answer++;
            }

            return -1;
        }
    }

}
