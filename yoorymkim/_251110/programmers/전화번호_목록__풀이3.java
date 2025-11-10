package _251110.programmers;

import java.util.*;

public class 전화번호_목록__풀이3 {

    class Solution {
        public boolean solution(String[] phone_book) {
            // 일단 시간초과는 for문 1개로 쇼부봐야 풀릴 것 같다 ?
            // 예외 !! 접두어가 아니라 포함여부를 따져서 예외 !!

            if (phone_book.length == 1) return true;

            HashSet<String> set = new HashSet();

            for (String s : phone_book) {
                set.add(s);
            }

            for (String s : phone_book) {
                for (int i = 1; i < s.length(); i++) {
                    // 전과 달리 s가 set중 무언가를 포함하고 있는지 검사
                    if (set.contains(s.substring(0, i))) return false;
                }
            }

            return true;
        }
    }
}
