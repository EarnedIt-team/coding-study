package _251111.programmers;

import java.util.*;

public class 더_맵게__풀이3 {

    class Solution {
        public int solution(int[] scoville, int K) {
            Arrays.sort(scoville);
            int answer = 0;
            int start = 0;
            int n = scoville.length;

            // 최소값이 K 이상이 될 때까지, 그리고 최소 2개 이상 남아 있을 때 반복
            while (start < n - 1 && scoville[start] < K) {
                int newVal = scoville[start] + scoville[start + 1] * 2;
                answer++;

                // 첫 번째 값은 소비, 두 번째 자리에 새 값 덮어쓰기
                scoville[start + 1] = newVal;
                start++;

                Arrays.sort(scoville, start, n);
            }

            return scoville[start] < K ? -1 : answer;
        }
    }
}
