import java.util.*;

class Solution {
    public int solution(String s) {
        
        // 문자열 길이 0 될 때까지? 반복
        
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        
        while(sb.length() > 0) {
            // System.out.println("현재 :" + sb.toString());
            // 첫 글자 읽기
            char c = sb.charAt(0);
            
            int same = 0; // 같은 문자 등장 횟수
            int diff = 0; // 다른 문자 등장 횟수;
            int cut_idx = sb.length() - 1; // 잘라야할 구간 idx (기본값으로 마지막 인덱스로)
            
            // 체크
            for(int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i) == c) same++;
                else diff++;

                // 횟수가 같다면
                if(same == diff) {
                    // System.out.println("same :"+ same + "diff : " + diff);
                    cut_idx = i;
                    break;
                }
            }
            // System.out.println("cut_idx: "+ cut_idx);
            sb.delete(0, cut_idx+1);
            answer++;
        }
        
        return answer;
    }
}