import java.util.*;

class Solution
{
    public int solution(String s)
    {
        // 스택 이용
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 꺼내서 위에서 두개를 비교
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}