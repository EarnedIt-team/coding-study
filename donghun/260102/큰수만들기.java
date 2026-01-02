import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // k개를 제거했을 때, 기존의 문자열 순서는 바뀌면 안됨
        
        StringBuilder sb = new StringBuilder(number);
    
        int i = 0;
        while(i < sb.length() - 1 && k > 0) {
            if(sb.charAt(i) < sb.charAt(i+1)) {
                sb.deleteCharAt(i);
                k--;
                if(i > 0) i--; // 한칸 뒤로가서 재비교
            } else i++;
        }
        
        if(k > 0) {
            sb.delete(sb.length()-k, sb.length());
        }

        return sb.toString();
    }
}