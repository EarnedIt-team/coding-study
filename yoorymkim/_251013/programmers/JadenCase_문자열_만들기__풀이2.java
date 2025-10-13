package _251013.programmers;

import java.util.*;

public class JadenCase_문자열_만들기__풀이2 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        // 공백 포함해서 단어 단위로 나누기
        String[] arr = s.split("(?<= )|(?= )");

        for (String word : arr) {
            if (word.equals(" ")) {
                sb.append(" "); // 공백 그대로 유지
            } else {
                // 첫 글자 대문자, 나머지 소문자
                sb.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    sb.append(word.substring(1).toLowerCase());
                }
            }
        }

        return sb.toString();
    }
}
