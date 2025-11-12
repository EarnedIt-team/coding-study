import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        // DFS : 깊이 우선 탐색, "최대한 깊게 탐색" 하기 위해 한 방향으로 검사
        // BFS : 너비 우선 탐색, "최단 경로"를 위해 시작 기준 가장 가까운 노드를 검사
        int answer = 0;
        
        int n = maps.length; // 세로
        int m = maps[0].length; // 가로
        
        // [0,0] 기준 우측으로 이동한다면 좌표상으로 [1,0]
        // 즉, x는 움직이고(1) y는 움직이지 않음(0) *대각선으로 이동 X
        int[] x = {-1, 1, 0, 0}; // 좌, 우
        int[] y = {0, 0, -1, 1}; // 상, 하
        
        boolean[][] visited = new boolean[n][m]; // 방문 체크
        Queue<int[]> queue = new LinkedList<>(); // 다음에 이동할 좌표가 담긴 공간
        
        queue.offer(new int[]{0, 0, 1}); // 초기 세팅 (x, y, 이동거리)
        visited[0][0] = true; // 초기 지점(0, 0)은 방문했다고 설정
        
        // 이동 가능한 좌표가 있으면 진행
        while(!queue.isEmpty()) {
            int[] position = queue.poll();
            
            int posX = position[0];
            int posY = position[1];
            int dist = position[2]; // 현재까지 이동거리
            
            // 도착 지점 도달 시 현재 거리 반환
            if (posX == n - 1 && posY == m - 1) return dist;
            
            for (int i = 0; i < 4; i++) {
                int move_x = posX + x[i];
                int move_y = posY + y[i];

                // 맵 범위내에서 이동이 가능한가?
                if (move_x >= 0 && move_y >= 0 && move_x < n && move_y < m) {
                    // 벽인가 아닌가?
                    if (maps[move_x][move_y] == 1) {
                        // 방문 한 적이 있는가?
                        if (!visited[move_x][move_y]) {
                            // 이동가능한 좌표를 모두 넣음
                            visited[move_x][move_y] = true;
                            queue.offer(new int[]{move_x, move_y, dist + 1});
                        }
                    }
                }
            }
        }
        
        return -1; // 도착할 수 없는 경우
    }
}
