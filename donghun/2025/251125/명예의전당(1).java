import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        List<Integer> answer = new ArrayList<>();
        
        List<Integer> grade = new ArrayList<>();
    
        for(int sc : score) {
            grade.add(sc);
            Collections.sort(grade, Collections.reverseOrder()); // 내림차순 정렬
            
            if(grade.size() <= k) {
                int lastValue = grade.get(grade.size() - 1);
                answer.add(lastValue);
            } else {
                answer.add(grade.get(k-1));
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}