import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        // [1, 2, 2, 3, 3, 4, 5, 5]
        
        // 귤 크기를 Map에 기록하고 value가 높은 값 순서로 정렬
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int tang : tangerine) {
            map.put(tang, map.getOrDefault(tang, 0) + 1); // 해당 귤의 크기를 카운트
        }
        
        // map에 저장된 값을 저장할 리스트
        List<int[]> list = new ArrayList<>();
        
        // 리스트에 키-값 저장
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        // 정렬
        list.sort((a,b) -> b[1] - a[1]);
        
        
       int answer = 0;

        int sum = 0;
        for (int[] arr : list) {
            sum+= arr[1];
            answer++;

            if(sum >= k) break;
            
            // System.out.println("[" + arr[0] + "," + arr[1] + "]");
            
        }
        
        
        
        return answer;
    }
}