import java.util.*;

class Solution {
    public long solution(int[] weights) {
        // 최소 공배수.. ?
        // 2, 3, 4 m 지점에 좌석이 하나씩 있음.
        
        // 각 weights에 대한 2,3,4 곱한 값을 전부 저장해놓기?
        // 그리고 다시 for문을 돌며 HashMap을 EntryMap으로 순회하여 2,3,4 곱한 값 들어가는지?
        
        // 이전 등장 여부 체크
        Map<Integer, Integer> map = new HashMap<>();
        
        // 등장 가능한 거리 비율쌍들 모두 저장
        int[][] ratios = {
            {1, 1}, // 2:2
            {2, 3},
            {3, 4},
            {1, 2},
            {3, 2},
            {4, 3},
            {2, 1}
        };
        
        long answer = 0;
        
        // 100 : {1:1}
        
        for(int w : weights) {
            for(int[] ratio : ratios) {
                if(w * ratio[0] % ratio[1] == 0) {
                    int pair = w * ratio[0] / ratio[1];    
                    
                    if(map.containsKey(pair)) {
                        answer += map.get(pair);
                    }
                }
            }
            
            // 현재 몸무게 추가
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        return answer;
    }
}