package _251020.programmers;

import java.util.*;

public class 이진_변환_반복하기__풀이2 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (s.length() != 1) {
            StringBuilder sb = new StringBuilder(s.length());
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') answer[1]++;
                else sb.append("1");
            }
            s = sb.toString();
            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }
        return answer;
    }
}
