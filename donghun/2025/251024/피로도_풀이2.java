// 풀이 2. 성공 (answer 값을 Math.max 함수를 사용하여 최대값 갱신)
import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        int depth = 0;
        
        // dfs 알고리즘으로 가장 깊이가 큰 값을 리턴하는 식으로 ㄱㄱ
        dfs(k, dungeons, visited, depth);
        
        return answer;
    }
    
    void dfs(int k, int[][] dungeons, boolean[] visited, int depth) {
        answer = Math.max(answer, depth);
        for(int i = 0; i < dungeons.length; i++) {
            
            // 아직 방문하지 않았고, 최소 필요 피로도 조건이 맞다면
            if(!visited[i] && dungeons[i][0] <= k) {
                
                // 해당 던전 방문 표시
                visited[i] = true;
                
                dfs(k - dungeons[i][1], dungeons, visited, depth+1);
                
                // 최대 깊이까지 방문 후 false 처리
                visited[i] = false;
            } 
        }
    }
}