package _251125.programmers;

import java.util.*;

public class H_Index {
    class Solution {
        public int solution(int[] citations) {
            // h번 이상 인용된 논문이 h편 이상, 나머지는 이하(같아도 됨),h의 최댓값
            // 6 5 3 1 0

            Arrays.sort(citations);
            int len = citations.length;
            int h = 0;

            for (int i = len - 1; i >= 0; i--) {
                if (citations[i] >= len - i) h = len - i;
                else break;
            }

            return h;
        }
    }
}
