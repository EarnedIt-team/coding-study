import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        /// Greedy 알고리즘 (탐욕법)
        /// 각 단계에서 최적이라고 판단되는 것을 선택
        /// 가벼운 + 가벼운 사람이 타게 되면 손실보는 무게 제한이 생기기 때문에
        /// [20, 20, 80, 80] => [20, 20] (60kg 무게 손실)
        /// 가벼운 + 무거운 사람이 타게되는 조합을 보는것이 제일 이상적
        /// 무거운 사람을 먼저 태우고, 가벼운 사람을 추가적으로 태움으로서 무게 손실을 최소화
        
        Arrays.sort(people); // 오름차순 정렬
        
        int left = 0; // 가장 가벼운 사람
        int right = people.length - 1; // 가장 무거운 사람
        int answer = 0;

        // 모든 인원이 배를 탈 때까지,
        while (left <= right) {
            // 가벼운 사람 + 무거운 사람 <= 무게 제한이라면
            if (people[left] + people[right] <= limit) {
                left++; // 가벼운 사람 탑승 (bonus)
            }
            
            right--; // 무거운 사람 탑승 (default)
            answer++; // 구명보트 사용
        }

        return answer;
    }
}
