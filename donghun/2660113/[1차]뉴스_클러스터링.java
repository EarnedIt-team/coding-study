import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        // str1, str2를 2개씩 끊어서 리스트에 삽입하자
        List<String> str1_split = strToList(str1);
        List<String> str2_split = strToList(str2);
        
        // 두 집합이 모두 공집합일 때
        if(str1_split.size() == 0 && str2_split.size() == 0) {
            return 65536;
        }
        
        // 합집합,교집합 계산
        List<String> union = new ArrayList<>(str1_split);
        List<String> interSection = new ArrayList<>();
        
        for(String s : str2_split) {
            // 교집합인 경우
            if(str1_split.contains(s)) {
                interSection.add(s); 
                str1_split.remove(s); // 중복 고려
            } else { // 교집합이 아닌 경우
                union.add(s);
            }
        }
        
        // 유사도 출력
        return 유사도계산(union.size(), interSection.size());
    }
    
    // String 입력을 List로 반환하는 메서드
    private List<String> strToList(String str) {
        
        List<String> str_split = new ArrayList<>();
        String prev = "";
        String next = "";
        String result = "";
        
        for(int i = 0; i < str.length()-1; i++) {
            
            prev = String.valueOf(str.charAt(i));
            next = String.valueOf(str.charAt(i+1));
            result = prev+next;
            
            // 특수문자 들어온 경우 pass (정규식 활용)
            if(!result.matches("^[A-Za-z]+$")) {
                continue;
            }
            
            str_split.add(result.toLowerCase());
        }
        
        return str_split;
    }
    
    // 자카드 유사도 계산 메서드
    private int 유사도계산(int unionSize, int interSize) {
        
        double result = ((double)interSize / unionSize) * 65536;
        
        return (int) result;
    }
}