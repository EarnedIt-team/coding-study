import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        // mod 연산 이용
        while(n > 0) {
            int 나머지 = n % 3;
            n /= 3;
            
            if(나머지 == 1) {
                sb.append("1");
            } else if (나머지 == 2) {
                sb.append("2");
            } else { // 나머지 == 0
                sb.append("4");
                n--;
            }
        }
        
        return sb.reverse().toString();
    }
}