package _251017.programmers;
import java.util.*;

public class 숫자_문자열과_영단어 {
    public int solution(String s) {
        // s의 길이가 최대 50인데 왜 return을 저리도 넉넉하게 준걸가 ,, 훼이크시도인가
        // 정규식 ?

        s = s.replaceAll("zero", "0")
                .replaceAll("one", "1")
                .replaceAll("two", "2")
                .replaceAll("three", "3")
                .replaceAll("four", "4")
                .replaceAll("five", "5")
                .replaceAll("six", "6")
                .replaceAll("seven", "7")
                .replaceAll("eight", "8")
                .replaceAll("nine", "9");

        return Integer.parseInt(s);
    }
}
