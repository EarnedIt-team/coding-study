// 풀이 1 - 실패 (99 같은 경우 연쇄 처리 못함)
import java.util.*;

class Solution {
    public int solution(int storey) {
        // 0층으로 내려가려면 최소 몇개의 마법의 돌이 필요한지 리턴하는 문제
        
        // # 예시 2. 2554
        // -1 x 4 -> 2550
        // 100 x 4 -> 2950
        // 10 x 5 -> 3000
        // -1000 x 3 -> 0
        
        // String 으로 접근해서 한자리씩 접근?
        // 255'4' -> '4' < 5 -> -1 x 4
        // 25'5'0 -> '5' >= 5 -> 10 x 5 
        // 2'6'00 -> '6' >= 5 -> 100 x 4
        // '3'000 -> '3' < 5 -> -1000 x 3
        // -> 4 + 5 + 4 + 3 = 16
        
        // 2554 -> [4,5,5,2]
        
        StringBuilder sb = new StringBuilder(storey + "");
        
        int answer = 0;
        
        // 1의 자리부터 접근 10^c 까지 접근하며 값을 변경
        for(int i = sb.length()-1; i >= 0; i--) {
            // System.out.println("현재 문자열 상태: " + sb.toString());
            
            // 해당 자리의 숫자 픽
            int pick = Integer.parseInt(String.valueOf(sb.charAt(i)));
            // System.out.println("현재 숫자: " + pick);
            
            if(pick < 5) { 
                answer+=pick; // 마법의 돌 pick개 사용
                
            } else { // pick >= 5
                // System.out.println("pick >= 5일때 :" + (10-pick));
                answer = answer + (10-pick); // 마법의 돌 10-pick개 사용
                
                int front = sb.charAt(i - 1) - '0'; 
                int newValue = front + 1;
                sb.setCharAt(i-1, (char) (newValue + '0'));
            }
            
            sb.deleteCharAt(i);
            if(sb.length() == 0) break;
        }
        
        return answer;
    }
}