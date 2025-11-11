package _251111.programmers;

import java.util.*;

public class 더_맵게__풀이5 {

    class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int s : scoville) pq.add(s);

            int answer = 0;
            while (pq.size() > 1 && pq.peek() < K) {
                int first = pq.poll();
                int second = pq.poll();
                pq.add(first + (second * 2));
                answer++;
            }

            return pq.peek() < K ? -1 : answer;
        }
    }

}
