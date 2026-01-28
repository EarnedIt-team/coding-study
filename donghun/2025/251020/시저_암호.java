import java.util.*;

class Solution {
    public String solution(String s, int n) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // 영문 a-z, A-Z 라면
            if('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z') {
                // n만큼 밀기
                for(int j = 0; j < n; j++) {
                    if(c == 'z') {
                        c = 'a';
                    } else if(c == 'Z') {
                        c = 'A';
                    } else {
                        c = (char)(c + 1);
                    }
                }
                sb.append(c);
                
            } else { // 공백이라면
                sb.append(" ");
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}