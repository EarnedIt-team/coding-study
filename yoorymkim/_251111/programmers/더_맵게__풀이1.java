package _251111.programmers;

import java.util.*;

public class 더_맵게__풀이1 {

    class Solution {
        public int solution(int[] scoville, int K) {
            //섞은거 = 덜매운거 + 매운거*2 , 순서는 가장 낮은 것들부터 (반복시 계속 정렬)
            //초기 K 미달인 것들끼리만 연산해도 충분할듯 : 1 2 3 ->  3 5 -> 13

            ArrayList<Integer> list = new ArrayList<>();

            Arrays.sort(scoville);
            for (int i = 0; i < scoville.length; i++) {
                if (scoville[i] >= K) break;
                else list.add(scoville[i]);
            }

            int answer = 0;
            while (list.size() > 1) {
                int n = list.get(0) + list.get(1)*2;
                if (n < K) list.add(n);
                list.remove(1);
                list.remove(0);

                answer++;
                Collections.sort(list);
            } // list.size() == 0 or 1

            if (list.size() == 1) answer++;

            return answer;
        }
    }
}
