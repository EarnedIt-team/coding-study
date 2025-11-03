import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 모든 조합의 수를 구하기
        // 각 타입에 따라 옷의 수를 구했을 때 
        // result = (count1 + 1) * (count2 + 1) * ... (countN + 1) 임. -> 여기서 + 1 은 해당 옷을 안 입은 경우
        // 예제 1의 경우, headgear = 2, eyewear = 1 이기 때문에 result = (2+1) * (1+1) = 6
        // 근데 아무것도 안 입은 경우도 제외해야함. 따라서 정답에서 -1
        
        Map<String, List<String>> map = new HashMap<>();
        int answer = 1;
        
        for(int i = 0; i < clothes.length; i++) {
            String name = clothes[i][0];
            String type = clothes[i][1];
            
            // 이미 key가 있다면 기존 리스트에 추가
            map.computeIfAbsent(type, k -> new ArrayList<>()).add(name);
        }
        
        // 각 key별 value 리스트 출력
        for (String key : map.keySet()) {    
            // System.out.println(key + " -> " + map.get(key) + " " + map.get(key).size());
            
            // 각 타입의 (count + 1) 을 계속 곱함
            answer *= (map.get(key).size() + 1);
        }
        
        // 아무것도 안 입는 경우 1개 제외
        return answer - 1;
    }
}