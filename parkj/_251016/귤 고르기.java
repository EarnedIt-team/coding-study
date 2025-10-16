import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        /// 수확한 귤 중에서 k개를 골라 상자 하나에 담아 판매
        /// 크기의 종류를 최소화 하고 k개를 담아서 판매하고 싶다.
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // 수확한 귤 사이즈별로 Map에 삽입
        for (int size : tangerine) {
            // 초반 null 방지를 위한 getOrDefault
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        // 배열로 변환 (map의 value 값들만 반환)
        List<Integer> countArr = new ArrayList<>(map.values());
        // 개수가 많은대로 내림차순
        countArr.sort(Collections.reverseOrder());
        
        int answer = 0;
        int total = 0;
        
        // 최소 종류 : 사이즈가 많은 개수대로 계산
        for (int count : countArr) {
            total += count;
            answer += 1;
            // 만약, total 값이 k과 같거나 넘어가면 최소 종류로 판매가 가능하다는 의미
            if (total >= k) break;
        }
        
        return answer;
    }
}
