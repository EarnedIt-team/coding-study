package _251110.programmers;

import java.util.*;

public class 전화번호_목록__풀이1 {
    class Solution {
        public boolean solution(String[] phone_book) {
            HashSet<String> set = new HashSet();

            for (String s : phone_book) {
                s = s.replace(" ", "");
                set.add(s);
            }

            for (int i = 0; i < phone_book.length-1; i++) {
                for (int j = i+1; j < phone_book.length; j++) {
                    String s1 = phone_book[i];
                    String s2 = phone_book[j];
                    if (s1.length() > s2.length() && s1.contains(s2)) return false;
                    else if (s1.length() < s2.length() && s2.contains(s1)) return false;
                }
            }

            return true;
        }
    }
}
