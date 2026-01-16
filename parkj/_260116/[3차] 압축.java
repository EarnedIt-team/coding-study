import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new LinkedHashMap<>(); // 사전
        List<Integer> answer = new ArrayList<>();
        
        // 기본 사전 초기화 (A-Z)
        int nextIndex = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), nextIndex++);
        }
        
        String temporaryStr = ""; // 임시 공간
        for (int i = 0; i < msg.length(); i++) {
            String w = temporaryStr + msg.charAt(i); // 받아온 문자를 추가        
            // 사전에 있으면 계속 확장 (가장 긴 문자열을 찾기 위함)
            /// KAKAO 기준, String w = "K" 가 존재한다면 다음으로 넘김
            /// String w = "KA" 가 존재한다면 다음으로 넘김... (반복)
            if (dictionary.containsKey(w)) {
                temporaryStr = w;
            } else {
                // 사전에 없으면, 이전에 이미 증명해둔 temporaryStr의 값을 사용
                answer.add(dictionary.get(temporaryStr));
                
                // 사전에 없는 새로운 조합 'w'를 추가
                dictionary.put(w, nextIndex++);
                
                // 현재 문자부터 다시 시작
                temporaryStr = String.valueOf(msg.charAt(i));
            }
        }
        
        // 마지막에 남아있는 문자열 처리
        if (!temporaryStr.equals("")) answer.add(dictionary.get(temporaryStr));
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
