package _251017.programmers;
import java.util.*;

public class 짝지어_제거하기__풀이1 {
    public int solution(String s) {
        // 문자들이 짝수개면 무조건 가능 아닌가? : abab -> 불가임
        // 문자들이 짝수개 + (c(aa)(bb)(aa)(b(aa)b)(aa)c) -> 괄호로 남는 것 없이 깔끔하게 묶여야 함

        // 스택 pop과 유사 ?!

        StringBuilder sb = new StringBuilder(s);
        boolean changed = true;

        while (changed) {
            changed = false;

            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.deleteCharAt(i + 1);
                    sb.deleteCharAt(i);

                    changed = true;
                    i = Math.max(-1, i - 2); // 인덱스 조정, -1은 안되게 .. 최대한 효율적으로
                }
            }
            if (changed == true) continue;
            else break;
        }

        return sb.length() == 0 ? 1 : 0;
    }

    // 정확도 100% 통과, 효율성 탈락 ..
}
