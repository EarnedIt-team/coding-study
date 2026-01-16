import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        char a = 'A';
        int num = 27;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
        
        // 대문자 A-Z map 세팅
        for(int i = 1; i <= 26; i++) {
            map.put(String.valueOf(a), i);
            a++;
        }
        
        int i = 0;
        while(i < msg.length()) {
            String w = msg.charAt(i) + "";
            int j = i + 1;
            
            // 해당 위치부터 자른 문자열이 포함안되어있을때까지 검사
            while(j <= msg.length() && map.containsKey(msg.substring(i, j))) {
                w = msg.substring(i, j);
                j++;
            }
            
            // 출력 배열에 추가
            result.add(map.get(w));
            
            // 다음 문자까지 사전에 등록
            if(j <= msg.length()) {
                map.put(msg.substring(i, j), num++);
            }
            
            // 다음 탐색 위치 이동
            i += w.length();
        }
        
        int[] answer = new int[result.size()];
        for(int j = 0 ; j < result.size(); j++) {
            answer[j] = result.get(j);
        }
        
        return answer;
    }
}