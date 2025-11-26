import java.util.*;

/// 캐시 교체 알고리즘 LRU (Least Recently Used Algorithm)
/// 메모리가 남아 있는 캐시 중 가장 오래동안 사용되지 않은 캐시를 새로운 캐시로 교체
/// ArrayList로도 가능은 하겠지만, 효율성을 생각하면
/// 가장 많이 구현하는 Queue + HashSet 방식을 사용함

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5; // 캐시 공간이 0 이라면, 모든 처리를 cache miss 진행
        int answer = 0;

        /// Queue : FIFO, 먼저 들어온게 먼저 나감
        Queue<String> queue = new LinkedList<>(); // 도시 이름 캐시 위치
        Set<String> set = new HashSet<>(); // 도시 이름 캐시 데이터

        // 실행시간 검사
        /// [서울, 부산, 경기]
        /// + 경기
        /// ["경기", 서울, 부산] (기존 캐시에 있었음)
        /// + 강원
        /// ["강원", 경기, 서울] (캐시에 없었음)
        for (String city : cities) {
            city = city.toUpperCase(); // 검사를 용이하기 위해 대문자로 변경

            // cache hit (캐시에 있다면)
            if (set.contains(city)) {
                queue.remove(city);  // 기존 위치 제거
                queue.add(city); // 위치 업데이트
                
                answer++;
            }
            // cache miss (캐시에 없다면)
            else {
                // 공간이 가득찼다면, 오래된 데이터 제거
                if (queue.size() == cacheSize) set.remove(queue.poll());
                set.add(city); // 데이터 저장
                queue.add(city); // 위치 저장
                
                answer += 5;
            }
        }

        return answer;
    }
}
