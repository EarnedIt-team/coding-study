package _251013.programmers;

import java.util.*;

public class 다음_큰_숫자 {

    public int solution(int n) {

        // 10 0 1110 : 카운트 3, len 7, index 2
        // -> 10 1 0011

        // 1 011 : 카운트 2, len 4, index 1
        // -> 1 1 01

        // 111 == 0111 // !!!!@!@!@ 중요 예외 케이스 ~~~~~~~~~
        // -> 1 011
        // 결국, 찾은 0->1 바꾸고, 나머지는 개수맞춰서 0000111 형태가되

        // 1100 == 01100
        // -> 10001 // !!!!@!@!@ 중요 예외 케이스 ~~~~~~~~~
        //


        String n2 = Integer.toBinaryString(n);
        int len = n2.length();

        int count1 = 0;
        int index = -1;

        boolean found1 = false;
        for (int i = len - 1; i >= 0; i--) {
            if (n2.charAt(i) == '1') {
                count1++;
                found1 = true;
            }
            else if (found1) { // 앞자릿수에 0연속일경우까지
                index = i;
                break;
            }
        }


        StringBuilder sb = new StringBuilder();

        // 예외 1111 : 맨앞에 1붙이기. 0 넣어야함 ~!
        if (index == -1) {
            sb.append("1"); // 맨 앞 1
            for (int i = 0; i < len - count1 + 1; i++) sb.append('0'); // 0 채우기
            for (int i = 0; i < count1 - 1; i++) sb.append('1'); // 나머지 1
            return Integer.parseInt(sb.toString(), 2);
        }

        // 나머지 보통경우
        for (int i = 0; i < index; i++) sb.append(n2.charAt(i)); // index 전까지 그대로
        sb.append("1"); // index자리에 1박기

        // 찍을0 = 총길이 - (그대로찍은거 + 1) - 카운트 + 1
        // 그대로찍은거 == index
        int zero = len - (index + 1) - (count1 - 1); // 찍을 0 개수
        for (int i = 0; i < zero; i++) sb.append("0");
        for (int i = 0; i < count1 - 1; i++) sb.append("1");

        return Integer.parseInt(sb.toString(), 2);
    }
}
