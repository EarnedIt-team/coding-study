import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < food.length; i++) {
            if(i == 0) continue;
            
            int count = 0;
            // 만약 홀수 개라면 -1 한것을 2로 나눔
            if(food[i] % 2 == 1) {
                count = (food[i] - 1) / 2;
            } else { // 짝수개면 그대로 2로 나눔
                count = food[i] / 2;
            }
            
            // 정방향 
            for(int j = 0; j < count; j++) {
                sb.append(i);
            }
        }
        
        // 역방향
        StringBuilder sb2 = new StringBuilder(sb).reverse();
        // 0 추가
        sb.append("0");
        sb.append(sb2.toString());
        
        return sb.toString();
    }
}