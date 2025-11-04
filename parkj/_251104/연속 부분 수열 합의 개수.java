import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>(); // 중복되는 합을 제외한 나머지 전체
        
        // 시작 지점 (i)
        for(int i = 0; i < elements.length; i++) {
            int sum = 0; // 수열의 합
            // 시작 지점(i)을 기준으로 수열의 합 구하기
            for(int j = 0; j < elements.length; j++) {
                // 배열의 끝을 넘어가서 원형으로 처리하기 위한 수단
                // EX. 시작 지점이 1이라면
                // {1}, {1,1}, {1,1,4}, {1,1,4,7}, {1,1,4,7,9}
                sum += elements[(i + j) % elements.length];
                set.add(sum);
            }
        }
        return set.size();
    }
}
