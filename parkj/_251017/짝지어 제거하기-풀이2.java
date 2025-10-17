/// 정답
/// Stack으로 처리하다보니 시간적인 이점이 존재 (이전 풀이와 최대 55 ~ 60배 차이남)
/// 문자열을 "수직"으로 보고 그거를 처리하는 방식

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = -1;
        Stack<Character> stack = new Stack<>();

        for (char chr : s.toCharArray()) {
            // stack에 값이 존재하고, 가장 앞에있는 값이 "동일한 문자일 때"
            if (!stack.isEmpty() && stack.peek() == chr) {
                // stack에 추가하지 않고, 앞에있던 문자를 제거
                stack.pop();
            } else {
                stack.push(chr);
            }
        }

        // stack이 비어있다 == 짝지어 제거하기를 성공적
        answer = stack.isEmpty() ? 1 : 0;
        
        return answer;
    }
}
