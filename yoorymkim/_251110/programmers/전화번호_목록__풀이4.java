package _251110.programmers;

import java.util.*;

public class 전화번호_목록__풀이4 {

    class Solution {
        public boolean solution(String[] phone_book) {
            // 일단 시간초과는 for문 1개로 쇼부봐야 풀릴 것 같다 ?
            // 예외 !! 접두어가 아니라 포함여부를 따져서 예외 !!

            if (phone_book.length == 1) return true;

            Arrays.sort(phone_book);

            for (int i = 0; i < phone_book.length-1; i++) {
                if (phone_book[i+1].startsWith(phone_book[i])) return false;
            }

            return true;
        }
    }
}
