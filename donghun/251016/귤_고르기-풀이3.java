import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        // 귤 크기를 Map에 기록하고 value가 높은 값 순서로 정렬
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int tang : tangerine) {
            map.put(tang, map.getOrDefault(tang, 0) + 1); // 해당 귤의 크기를 카운트
        }
        
        // map에 저장된 값을 저장할 리스트
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder()); // 내림차순 정렬
        
        int answer = 0;
        int sum = 0;
        
        for (int value : list) {
            sum+= value;
            answer++;

            if(sum >= k) break;
        }
        
        return answer;
    }
}