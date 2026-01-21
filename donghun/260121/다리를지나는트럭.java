import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 다리에 올라갈 수 있는 트럭 수 bridge_length
        // 다리가 견딜 수 있는 무게 weight
        // 트럭 별 무게 truck_weigth
        
        // 소요 시간
        int duration = 1;
        int pick = 0; // 트럭 idx
        
        // 다리를 지난 트럭 관리 (truck_weights)
        List<Integer> arrived_truck = new ArrayList<>();
        // 각 트럭의 소요 시간 관리
        Map<Integer, Integer> map = new HashMap<>();
        
        // 현재 다리 위에 지나가는 트럭의 무게 합
        int current_weight = 0;
        
        // 도착 트럭의 길이와 대기 중이였던 트럭의 길이가 같아지면 종료
        while(arrived_truck.size() < truck_weights.length) {
            int on_bridge = truck_weights[pick];
            
            // 무게를 견딜 수 있다면 다리 위에 추가
            if(map.get(pick) == null && (current_weight+on_bridge) <= weight) {
                // System.out.println("트럭 진입합니다: " + pick + "번 트럭");
                map.put(pick, 0); // 해당 트럭의 소요 시간 삽입
                current_weight += on_bridge;
                if(pick < truck_weights.length-1) {
                    pick++; // 다음 트럭    
                }
            }
            
            // 다리 위의 모든 트럭의 시간을 +1 증가시켜야함
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                entry.setValue(entry.getValue() + 1);
            }
            
            // 다리를 건넌 트럭이 있다면 현재 다리 위 트럭 무게 업데이트
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            
            while(it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                
                // 다리 길이만큼 도달했다면
                if(entry.getValue() == bridge_length) {
                    int key = entry.getKey();
                    arrived_truck.add(key); // 도착 List에 추가하고
                    it.remove(); // 안전하게 제거
                    
                    // 그 트럭의 무게만큼 현재 다리 위 트럭 무게에서 빼기
                    current_weight-= truck_weights[key];
                }
            }
            
            duration++; // 소요 시간 1 증가
        }
        
        return duration;
    }
}