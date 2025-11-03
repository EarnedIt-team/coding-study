package _251103.programmers;

import java.util.*;

public class 괄호_회전하기 {

    class Solution {
        public int solution(String s) {
            // 전에 푼 문제중 (((x))(x))...느낌으로 괄호를 묶는 것과 유사함 -> 터트리기용 스택
            // 회전은 sb로 맨앞떼서 맨뒤붙이기.
            // 완전탐색 필요(전체 회전경우에서 count 필요)

            // [](){} -> 192837 로 치환, 더해서 10되면 ok
            s = s.replace("[", "1").replace("]", "9")
                    .replace("(", "2").replace(")", "8")
                    .replace("{", "3").replace("}", "7");

            StringBuilder sb = new StringBuilder(s);
            int answer = 0;

            for (int i = 0; i < s.length(); i++) {
                if (possible(sb.toString())) answer++;

                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
            }

            return answer;
        }

        private boolean possible(String s) {
            Stack<Integer> st = new Stack<>();

            for (char c : s.toCharArray()) {
                int i = c - '0'; // 타입 변환 char -> int
                if (i == 1 || i == 2 || i == 3) { // [({ 라면
                    st.push(i);
                }
                else {
                    if (st.isEmpty()) return false; // ])} 나왔는데 앞에 [{( 없음
                    int prev = st.pop();
                    if (prev + i != 10) return false; // 짝이 안맞음
                }
            }

            return st.isEmpty();
        }
    }
}
