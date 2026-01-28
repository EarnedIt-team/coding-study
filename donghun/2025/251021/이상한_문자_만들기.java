import java.util.*;

class Solution {
    public String solution(String s) {
        // 문자열 쪼개고 각각에서 0~n으로 홀짝 판별하며 처리
        String[] str_split = s.split(" ", -1); // 중복 공백까지 생각하여 쪼개기
        
        StringBuilder sb = new StringBuilder();
        
        // 각 문자열 하나씩 꺼냄
        for(int i = 0; i < str_split.length; i++) {
            String str = str_split[i];
            // 홀짝 
            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                
                if(j % 2 == 0) { // 짝수라면 대문자
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
            
            // 마지막 단어가 아니라면 공백 추가
            if (i != str_split.length - 1) {
                sb.append(" ");
            }
        }
            
        return sb.toString();
    }
}