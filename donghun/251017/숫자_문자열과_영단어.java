// 풀이 1 - 성공
import java.util.*;

class Solution {
    public int solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        
        // 앞에서부터 문자열 검사
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 영어 소문자라면
            if('a' <= c && c <= 'z') {
                sb.append(c);
                
                int check = switch_engToNum(sb.toString());
                
                if(check != -1) {
                    result.append(check);
                    // sb 문자열 초기화
                    sb.setLength(0);
                }
            } else { // 숫자라면 정답 문자열에 추가
                result.append(c);
            }
        }
        
        // System.out.println(result.toString());
        
        return Integer.parseInt(result.toString());
    }
    
    
    
    private int switch_engToNum(String s) {
    switch (s) {
        case "zero": return 0;
        case "one": return 1;
        case "two": return 2;
        case "three": return 3;
        case "four": return 4;
        case "five": return 5;
        case "six": return 6;
        case "seven": return 7;
        case "eight": return 8;
        case "nine": return 9;
        default: return -1; 
    }
}
}