// 풀이 1. 효율성 테스트 통과 x
import java.util.*;

class Solution {
    // 정답 배열
    List<Integer> arr = new ArrayList<>();
    int answer = 0;
    
    public int solution(int[][] maps) {
        
        // 인접 행렬의 데이터를 확인하고 1인 방향으로 움직였을 때 최소 길이 계산
        
        // m*n 에서 목적 도착 직전 행렬 (m-1, n), (m, n-1) 이 막혀있다면 -1 리턴
        
        // 이동하는 방법
        // x좌표 또는 y좌표를 1씩 더하거나 1 빼기
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        // dfs 호출
        dfs(maps, visited, 0, 0, 1);
        
        Collections.sort(arr);
        // System.out.println(arr); 
        
        // 정답 배열의 사이즈가 0이 아니라면 첫번째 값 리턴, 정답이 존재하지 않으면 -1 리턴
        return arr.size() != 0 ? arr.get(0) : -1;
    }
    
    // 깊이 우선 탐색 메서드
    void dfs(int [][] maps, boolean[][] visited, int x, int y, int depth) {
        if(x == maps.length - 1 && y == maps[0].length-1) {
            arr.add(depth);
        }
        
        // 방문 처리
        visited[x][y] = true;
        
        // 상 하 좌 우
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};

        for(int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            // 맵을 빠져나왔는지 검사
            if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) continue;
            // 벽을 마주친다면
            if(maps[nx][ny] == 0) continue;
            
            // 아직 방문하지 않았다면
            if(!visited[nx][ny]) {
                // System.out.println("탐색 중: (" + nx + ", " + ny + ")");
                dfs(maps, visited, nx, ny, depth + 1);
                
                // 최대 깊이까지 방문 후, 방문 처리 해제
                visited[nx][ny] = false;
            }
            
        }
    }
}
