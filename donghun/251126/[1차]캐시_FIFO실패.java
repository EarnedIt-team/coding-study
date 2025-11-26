// 풀이1. FIFO 방식이라 틀림
class Solution {
    public int solution(int cacheSize, String[] cities) {
        // LRU 알고리즘
        // 가장 오랫동안 사용되지 않은 페이지를 교체하는 기법
        
        // Jeju, Pangyo, Seoul (5,5,5) = 15
        // Pangyo, Seoul, NewYork (5) = 20
        // Seoul, NewYork, LA (5) = 25
        // NewYork, LA, Jeju (5) = 30
        // LA, Jeju, Pangyo (5) = 35
        // Jeju, Pangyo, Seoul (5) = 40
        // PangYo, Seoul, NewYork (5) = 45
        // Seoul, NewYork, LA (5) = 50
        
        // 캐시 크기 0인 경우 그냥 길이x5 리턴
        if(cacheSize == 0) return cities.length*5;
        
        // 배열 ? 리스트 ? 정적인 배열 ㄱㄱ
        String[] cache = new String[cacheSize];
        
        int answer = 0;
        
        int idx = 0;
        for(String city : cities) {
            boolean hit = false;
            
            // cache에 존재하는지 확인
            for(String c : cache) {
                // cache hit +1 
                if(c != null && c.equalsIgnoreCase(city)) {
                    hit = true;    
                    break;
                }
            }
            
            if(hit) { // cache hit
                answer++;
            } else { // cache miss
                cache[idx] = city;
                answer+=5;
            }
            
            // 순환형 구조
            idx = (idx+1) % cacheSize;
        }
        
        return answer;
    }
}