import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        // 방법1. 숫자로 치환 (안됨)
        // "[](){}" -> "331122" 
        // "}]()[{" -> "231132"    
        
        // 방법2. 스택
        
        int count = 0; 
        for(int i = 0; i < s.length(); i++) {
            
            // 올바른 괄호 문자열 확인
            count += checkCorrectString(sb.toString());
            
            // (방법 1. 객체 계속 재할당하여 수행시간 살짝 김)
            // 문자열 왼쪽으로 회전 (정상 동작 확인) 
            String rotated = sb.substring(1, sb.length()) + sb.charAt(0);
            sb = new StringBuilder(rotated);

            // (방법 2. 유림님 방법, 수행시간 유의미하게 줄어듦. 재할당 x)
            // char c = sb.charAt(0);
            // sb.deleteCharAt(0); 
            // sb.append(c);
        }
        
        return count;
    }
    
    // 올바른 문자열인지 확인하는 메서드
    int checkCorrectString(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            // 열렸을 때
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else { // 닫힌 문자일 때
                if(stack.isEmpty()) return 0; // 스택이 비어있다면
                
                char top = stack.pop();
                
                if((c == ')') && top != '(' ||
                   (c == '}') && top != '{' ||
                   (c == ']') && top != '[') return 0;
            }
        }
        
        // 스택에 문자 남아있다면 올바른 문자열 x
        return stack.isEmpty() ? 1 : 0;
    }
}