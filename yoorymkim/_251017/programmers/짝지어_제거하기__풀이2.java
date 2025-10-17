package _251017.programmers;
import java.util.*;

public class 짝지어_제거하기__풀이2 {
    public int solution(String s) {
        // 문자들이 짝수개면 무조건 가능 아닌가? : abab -> 불가임
        // 문자들이 짝수개 + (c(aa)(bb)(aa)(b(aa)b)(aa)c) -> 괄호로 남는 것 없이 깔끔하게 묶여야 함

        // 스택 pop과 유사 ?!

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 안비어있고, 직전에 넣은게 같음
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c); // 아니면 추가
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
