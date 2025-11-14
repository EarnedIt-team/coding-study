import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        // 순서를 보장하는 집합
        Set<String> set = new HashSet<>();
    
        // 마지막 문자
        char last = words[0].charAt(words[0].length() - 1);

        int cycle = 0;
        for(int i = 0; i < words.length; i++) {
            // 1바퀴 돌때마다 사이클 수 갱신
            cycle = (i / n) + 1;
            
            // last와 시작 글자가 일치하지 않는다면
            if(i != 0 && words[i].charAt(0) != last) {
                answer[0] = (i%n) + 1; // 실패한 사람 번호
                answer[1] = cycle; // 사이클 수
                break;
            } 
            
            last = words[i].charAt(words[i].length() - 1); // 갱신
            
            // 중복 삽입
            if (!set.add(words[i])) {
                // 실패한 사람  
                answer[0] = (i%n) + 1; // 실패한 사람 번호
                answer[1] = cycle; // 사이클 수
                break;
            } 
        }

        return answer;
    }
}