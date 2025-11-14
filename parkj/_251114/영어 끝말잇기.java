import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        ArrayList<String> usedWords = new ArrayList<>(); // 사용한 words 기억하는 공간
        
        usedWords.add(words[0]); // 첫 단어 삽입
        
        for(int i=1; i < words.length; i++) {
            int user = (i % n) + 1; // 현재 누구 차례인지
            int turn = (i / n) + 1; // 몇번째 턴인지
            
            // 현재 단어가 이미 사용된 중복된 단어라면,
            // or 첫 문자가 이전 단어의 마지막 문자와 동일하지 않다면
            if (usedWords.contains(words[i]) || 
                words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)) {
                return new int[]{user, turn};
            } else {
                // 문제 없으면 사용하고 다음 턴으로 넘김
                usedWords.add(words[i]);   
            }
        }
        
        return new int[]{0, 0};
    }
}
