import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // LRU 알고리즘
        // 가장 오랫동안 사용되지 않은 페이지를 교체하는 기법
        
        // 캐시 크기 0인 경우 그냥 길이x5 리턴
        if(cacheSize == 0) return cities.length*5;
        
        // 들
        LinkedList<String> cache = new LinkedList<>();
        int answer = 0;
        
        for(String city : cities) {
            city = city.toLowerCase();
            
            // cache hit
            if (cache.remove(city)) {
                answer += 1; // hit 시 비용 1
            }  
            else { // cache miss
                answer += 5;
                if (cache.size() >= cacheSize) cache.removeFirst(); // 가장 오래된 항목 제거
            }

            // 항상 최신 항목은 맨 뒤에 추가
            cache.addLast(city);
        }
        return answer;
    }
}