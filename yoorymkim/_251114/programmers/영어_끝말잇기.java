package _251114.programmers;

import java.util.*;

public class 영어_끝말잇기 {

    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[2];
            HashSet<String> set = new HashSet(); // 중복 거르기용

            char prev = words[0].charAt(0); // 시작해야 하는 ch
            for (int i = 0; i < words.length; i++) {
                String w = words[i];
                if (w.charAt(0) == prev && !set.contains(w) && w.length() != 1) { // 통과
                    set.add(w);
                    prev = w.charAt(w.length()-1);
                }
                else { // 걸림
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    break;
                }
            }

            return answer;
        }
    }
}
