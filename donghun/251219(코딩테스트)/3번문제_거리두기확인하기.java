import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++) {
            char[][] map = new char[5][5];
            
            for(int j = 0; j < 5; j++) {
                map[j] = places[i][j].toCharArray();
            }
            
            if(check(map)) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }
    
    // 각 대기실 거리두기 검사
    private boolean check(char[][] map) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                // 응시자 발견시 그 지점에서 탐색
                if(map[i][j] == 'P') {
                    if(!bfs(map, i, j)) return false;
                }
            }
        }
        return true;
    }
    
    // BFS로 거리 2 이하 검사
    private boolean bfs(char[][] map, int x, int y) {
        // 상하좌우 방향 
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // 방문 상태 2차원배열
        boolean[][] visited = new boolean[5][5];
        
        // bfs 탐색 위해 큐 선언
        Queue<int[]> q = new LinkedList<>();
        
        // 방문 처리 및 탐색 시작
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if (dist >= 2) continue; // 거리 2 초과 시 탐색 중단

            // 상하좌우 방향 모두 탐색 (bfs)
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 벽을 넘을 때 pass
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                
                // 이미 방문 상태
                if (visited[nx][ny]) continue;
                
                // 파티션이면 통과 불가
                if (map[nx][ny] == 'X') continue; 

                // dist가 2가 초과 되기전에 다른 응시자를 만났다면 거리두기 위반
                if (map[nx][ny] == 'P') return false; 

                // 방문 처리 후
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, dist + 1}); // 해당 방향 탐색 및 거리 갱신
            }
        }

        return true;
    }
}