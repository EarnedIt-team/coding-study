package _251117.programmers;

import java.util.*;

public class 튜플 {

    class Solution {
        public int[] solution(String s) {
            // 튜플은 배열같은거, 중복값 가능 -> set불가.
            // 거기서 집합 뽑기 -> 집함은 순서 노상관

//            StringTokenizer st = new StringTokenizer(s, ",");
//            HashMap<Integer, Integer> map = new HashMap(); // key:숫자, val:개수(1이상인지)
//
//            for(st.hasMoreTokens()) {
//                String zip = st.nextToken();
//                zip = s.substring(1, s.length() - 1);
//
//                StringTokenizer st2 = StringTokenizer(zip, ",");
//                for(st2.hasMoreTokens()) {
//                    int num = Integer.parseInt(st2.nextToken);
//                    if (map.containsKey(num)) {
//                        if(map.get(num)) {}
//                        // 중복처리 어떻게 카운트해야될까나 ..
//                    }
//                    else map.add(Integer.parseInt(st2.nextToken), 1);
//                }
//            }
//
//
//
//            return answer;
        }
    }
}
