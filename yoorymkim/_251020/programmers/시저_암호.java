package _251020.programmers;

import java.util.*;

public class 시저_암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(' ');
                continue;
            }

            if ('A' <= c && c <= 'Z') {
                // (c + n만큼증가 - 'A'까지의 현재거리) % 26 == 'A'부터 카운트해야할 거리
                c = (char) ((c + n - 'A') % 26 + 'A');
            } else if ('a' <= c && c <= 'z') {
                c = (char) ((c + n - 'a') % 26 + 'a');
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
