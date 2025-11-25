import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 먼저 f 의 값을 가장 큰 값에서 가장 작은 값까지 정렬합니다 .
        // [6, 5, 3, 1, 0]
        //  1, 2, 3 ,4, 5
        
        // 내림차순 정렬
        Integer[] tmp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        
        int answer = 0;
        
        for(int i = 0; i < tmp.length; i++) {
            if( (i+1) <= tmp[i]) {
                answer = i+1;
                // System.out.println("현재 순위 : " + (i+1) + " 인용 수 :" + tmp[i]);
            }
        }
        
        return answer;
    }
}