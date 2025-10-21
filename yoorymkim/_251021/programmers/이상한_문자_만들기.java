package _251021.programmers;

import java.util.*;

public class 이상한_문자_만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int num = 0;
        for (int i = 0; i < s.length(); i++, num++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(c);
                num = -1;
            } else if (num % 2 == 0) { // 짝
                sb.append(Character.toUpperCase(c));
            } else { // 홀
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
