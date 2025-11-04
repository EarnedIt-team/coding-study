package _251104.programmers;

import java.util.*;

public class 연속_부분_수열 {

    class Solution {
        public int solution(int[] elements) {
            // 연속부분수열 : 원수열에서 잘랐을때 나오는 수열들
            // 7 9 1 1 4 7 9 1 1 -> 2*len -1
            // 0 1 2 3 4 0 1 2 3 -> i%len(5)

            HashSet<Integer> set = new HashSet();
            int len = elements.length;

            for (int stInd = 0; stInd < len ; stInd++) { // 시작인덱스
                for (int i = 1; i <= len ; i++) { // 부분수열길이
                    int sum = 0;
                    for (int j = 0; j < i; j++) { // 부분수열인덱스
                        sum += elements[(stInd+j)%len];
                    }
                    set.add(sum);
                }
            }

            return set.size();
        }
    }
}
