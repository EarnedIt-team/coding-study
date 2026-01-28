import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
   
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Map 세팅
        for(int i=0; i<wires.length; i++) {
            int key = wires[i][0];
            int value = wires[i][1];
            
            // key와value에 대한 리스트가 없으면 생성
            map.putIfAbsent(key, new ArrayList<>());
            map.putIfAbsent(value, new ArrayList<>());
            
            // 값 추가
            map.get(key).add(value);
            map.get(value).add(key);
        }
        
        // 연결 상태 확인
        // for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() + " : " + entry.getValue());
        // }
        
        for(int[] wire : wires) {
            int key = wire[0];
            int value = wire[1];
            
            // 기존값 훼손 x 위해서
            Map<Integer, List<Integer>> deepCopy = new HashMap<>();
            
            // 깊은 복사 
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                deepCopy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
            }
            
            // 한쪽씩 끊기
            deepCopy.get(key).remove(Integer.valueOf(value));
            deepCopy.get(value).remove(Integer.valueOf(key));
            
            // System.out.println("바뀐 상태: " + deepCopy.get(key));
            
            // 자른 값 기준 종점 개수 최대깊이 탐색
            boolean[] visited = new boolean[n + 1];
            int cntA = dfsCount(deepCopy, key, visited);
            int cntB = n - cntA;
            int diff = Math.abs(cntA - cntB);
            
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    private int dfsCount(Map<Integer, List<Integer>> map, int node, boolean[] visited) {
        visited[node] = true;
        int count = 1;

        for (int next : map.get(node)) {
            if (!visited[next]) {
                count += dfsCount(map, next, visited);
            }
        }
        return count;
    }
}