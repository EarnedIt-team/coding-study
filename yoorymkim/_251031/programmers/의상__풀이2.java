package _251031.programmers;

import java.util.*;

public class 의상__풀이2 {

    class Solution {
        public int solution(String[][] clothes) {
            // [의상의 이름, 의상의 종류] : 순서 유의
            // (각 카테고리 개수 + 1(안고르기)) * ( ...) - 1(아무것도 안고름)

            HashMap<String, Integer> map = new HashMap(); // key:카테고리, val:개수

            for(String[] c : clothes) {
                if (map.containsKey(c[1])) map.put(c[1], map.get(c[1]) + 1);
                else map.put(c[1], 1);
            }

            int answer = 1;
            for (String key : map.keySet()) {
                int val = map.get(key);
                answer *= val+1;
            }

            return answer-1;
        }
    }
}
