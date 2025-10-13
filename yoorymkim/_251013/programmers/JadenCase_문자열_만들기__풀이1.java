package _251013.programmers;
import java.util.*;

public class JadenCase_문자열_만들기__풀이1 {
    public String solution(String s) {

        // StringTokenizer st = new StringTokenizer(s);
        // 연속 공백이 가능하기 때문에 .. 연속공백 처리 부적합

        String[] words = s.split("(?<= )|(?= )"); // 공백 연속 가능으로 split + 정규식
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (word.equals(" ")) { // 공백이면 추가하고 넘김
                sb.append(word);
                continue;
            }

            StringBuilder sbWord = new StringBuilder(word);

            // 첫글자 소문자면 -> 대문자 변환, 숫자면 내비둠
            if('a' <= word.charAt(0) && word.charAt(0) <= 'z') {
                sbWord.setCharAt(0, (char)(word.charAt(0) - ('a' - 'A')));
            }
            // 그뒤로는 대문자면 -> 소문자 변환
            for (int i = 1; i < word.length(); i++) {
                if ('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
                    sbWord.setCharAt(i, (char)(word.charAt(i) + ('a' - 'A')));
                }
            }

            sb.append(sbWord);
        }

        return sb.toString();
    }
}
