// 풀이 1. 점수 70, 실패(시간초과)
import java.util.*;

class Solution {
    public String solution(int n) {
        /*
        11: 42
        12: 44
        -> 100의 자리 추가 (1)
        13: 111
        14: 112
        15: 114
        16: 121
        17: 122
        18: 124
        19: 141
        20: 142
        21: 144
        -> 맨 앞자리 2로 변경
        22: 211
        23: 212
        ...
        -> 맨 앞자리 4로 변경
        ...
        -> 1000의 자리 추가 (1)
        */
        
        // StringBuilder를 이용해 문자열의 상태를 계속 변경하는 방식
        
        StringBuilder sb = new StringBuilder("1");
        
        // 1일 때는 돌지 않고, 2일 때는 한번 돌고, 4일 때도 한번 돌고, 
        for(int i = 1; i < n; i++) {
            // 문자열의 길이를 파악하고
            int str_last = sb.length()-1;
            sb = check(sb.toString(), str_last);
        }
        
        return sb.toString();
    }
    
    // 앞의 수를 재귀적으로 탐색하는 메서드 추가 필요
    private StringBuilder check(String str, int idx) {
        StringBuilder sb = new StringBuilder(str);
        char c = sb.charAt(idx);
        
        // 맨 앞까지 갔는데 숫자가 4라면 1을 추가해줘야함
        if(idx == 0 && c == '4') {
            sb.setCharAt(0, '1');
            sb.insert(0, '1');
            return sb;
        }
        
        // 앞의 숫자가 1또는 2라면 숫자를 올리고 반환
        if(c != '4') {
            if(c == '1') { // 1일 때
                sb.setCharAt(idx, '2');
                return sb;
            } else if(c == '2') { // 2일 때
                sb.setCharAt(idx, '4');
                return sb;
            }
        }
        
        // 4라면 해당 메서드를 한번 더 호출해서 앞에 검사
        if(c == '4') {
            sb.setCharAt(idx, '1'); // 현재 자리를 1로 되돌림
            sb = check(sb.toString(), idx - 1); // 앞자리 처리
        }
        
        return sb;
    }
}