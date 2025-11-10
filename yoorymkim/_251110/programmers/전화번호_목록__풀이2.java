package _251110.programmers;

import java.util.*;

public class 전화번호_목록__풀이2 {

    class Solution {
        public boolean solution(String[] phone_book) {
            // 아무리 생각해도 예외는 없는 것 같은데 ..

            if (phone_book.length == 1) return true;

            HashSet<String> set = new HashSet();

            for (String s : phone_book) {
                s = s.replace(" ", "");
                set.add(s);
            }

            for (String s : phone_book) {
                for (String setS : set) {
                    if (s.length() < setS.length()) { // 포함되려면 길이가 더 작아야함
                        if (setS.contains(s)) return false;
                    }
                }
            }

            return true;
        }
    }
}
