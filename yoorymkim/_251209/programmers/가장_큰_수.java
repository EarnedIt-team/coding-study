package _251209.programmers;

import java.util.*;

public class 가장_큰_수 {
    class Solution {
        public String solution(int[] numbers) {
            // 앞자리 숫자가 큰게 앞으로 오게 해야함 그 다음은 두번째 수 .. 반복
            // 6, 10 => 610 > 106 : 걍 2개씩 붙여보기

            String[] arr = new String[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

            // 000 -> 0으로 반환
            if (arr[0].equals("0")) return "0";

            StringBuilder sb = new StringBuilder();
            for (String s : arr) sb.append(s);

            return sb.toString();
        }
    }

}
