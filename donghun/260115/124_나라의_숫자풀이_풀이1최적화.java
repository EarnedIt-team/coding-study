// 풀이 1. 점수 70, 실패(시간초과) -> 최적화(check 메서드 내에서 StringBuilder 사용 줄임)
import java.util.*;

class Solution {
    public String solution(int n) {
        // StringBuilder를 이용해 문자열의 상태를 계속 변경하는 방식
        
        StringBuilder sb = new StringBuilder("1");
        
        // 1일 때는 돌지 않고, 2일 때는 한번 돌고, 4일 때도 한번 돌고, 
        for(int i = 1; i < n; i++) {
            // 문자열의 길이를 파악하고
            check(sb, sb.length()-1);
        }
        
        return sb.toString();
    }
    
    // 앞의 수를 재귀적으로 탐색하는 메서드 추가 필요
    private void check(StringBuilder sb, int idx) {
        char c = sb.charAt(idx);
        
        // 맨 앞까지 갔는데 숫자가 4라면 1을 추가해줘야함
        if(idx == 0 && c == '4') {
            sb.setCharAt(0, '1');
            sb.insert(0, '1');
            return;
        }
        
        // 앞의 숫자가 1또는 2라면 숫자를 올리고 반환
        if(c != '4') {
            if(c == '1') { // 1일 때
                sb.setCharAt(idx, '2');
                return;
            } else if(c == '2') { // 2일 때
                sb.setCharAt(idx, '4');
                return;
            }
        }
        
        // 4라면 해당 메서드를 한번 더 호출해서 앞에 검사
        if(c == '4') {
            sb.setCharAt(idx, '1'); // 현재 자리를 1로 되돌림
            check(sb, idx - 1); // 앞자리 처리
        }
    }
}