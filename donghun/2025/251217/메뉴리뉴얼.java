import java.util.*;

class Solution {
    // 조합 저장용 맵 (조합 등장 횟수)
    Map<String, Integer> comboMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        // 코스요리는 최소 2가지 이상
        // 단품 메뉴는 최소 2명 이상 손님에게 주문된 적 있어야함.
        // "가장 많이 주문된 단품 메뉴 조합"이 코스요리 구성이 됨
        
        // 앞에서부터 검사?
        // 어떤 문자 조합이 여러번 등장했는지를 검사해야함
        // 이 문자 조합을 어떻게 찾아냄.. ?
        
        // HashMap?
        // A ~ Z for문으로 뭔가 하기? (알파벳 배열 27개짜리에 각각의 개수 적어놓기)
        // ex) A : 2, B : 3, ... Z : 2
        
        // 예시 3
        // X : 3, Y : 2, W: 2, Z : 1, A : 1
        // X부터 검사?
        
        // 정답 배열
        List<String> result = new ArrayList<>();
        
        // 조합 생성
        for(String order : orders) {
            boolean[] visited = new boolean[order.length()];
            
            // course에 맞게 조합 확인
            for(int n : course) {
                // n개 짜리 조합을 모두 추출
                // 2: XY, ZX ...
                // 3: ABX, WXY ... 
                
                combination(order.toCharArray(), visited, 0, order.length(), n);
            }
        }    
        
        // course 수에 맞게 정답 도출
        for(int n : course) {
            int max = 0;
            for(Map.Entry<String, Integer> entry : comboMap.entrySet()) {
                String key = entry.getKey();
                int value = comboMap.get(key);
                
                // 문자열의 길이가 일치하면서 주문 등장 횟수 2회 이상
                if(key.length() == n && value >= 2) {
                    max = Math.max(max, value);
                }
            }
            
            // 나온 max값 기준으로 정답 배열 삽입
            for(Map.Entry<String, Integer> entry : comboMap.entrySet()) {
                String key = entry.getKey();
                int value = comboMap.get(key);
                
                // max 값과 일치하는 key값을 정답 배열에 삽입
                if(key.length() == n && value == max) {
                    result.add(key);
                }
            }
        }
        
        // 출력하여 확인
        // for (Map.Entry<String, Integer> entry : comboMap.entrySet()) {
        //     System.out.println(entry.getKey() + " : " + entry.getValue());
        // }

        // 마지막에 사전순 오름차순 정렬
        Collections.sort(result);
        
        // List -> array
        String[] answer = new String[result.size()];
        
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
    
        return answer;
    }
    
    // nCr 조합 기법
    void combination(char[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            saveCombination(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
    
    // 조합을 문자열로 합쳐 저장
    void saveCombination(char[] arr, boolean[] visited, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) sb.append(arr[i]);
        }
        String combo = sb.toString();
        // 1. 문자 배열로 변환
        char[] chars = combo.toCharArray();
        // 2. 문자 배열 정렬
        Arrays.sort(chars);
        // 3. 다시 문자열로 변환
        String sorted = new String(chars);

        // comboMap에 누적 저장
        comboMap.put(sorted, comboMap.getOrDefault(sorted, 0) + 1);
    }
}