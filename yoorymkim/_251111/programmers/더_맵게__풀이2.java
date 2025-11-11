package _251111.programmers;

import java.util.*;

public class 더_맵게__풀이2 {

    class Solution {
        public int solution(int[] scoville, int K) {
            //섞은거 = 덜매운거 + 매운거*2 , 순서는 가장 낮은 것들부터 (반복시 계속 정렬 필요함)

            Arrays.sort(scoville);
            ArrayList<Integer> list = new ArrayList<>();
            for (int s : scoville) list.add(s);

            int answer = 0;
            while (list.size() > 1 && list.get(0) < K) {
                int n = list.get(0) + list.get(1) * 2;

                list.remove(0);
                list.remove(0);
                list.add(n);

                answer++;
                Collections.sort(list);
            }

            if (list.get(0) < K) return -1;
            return answer;
        }
    }
}
