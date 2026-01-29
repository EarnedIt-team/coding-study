// 풀이 2. 효율성 테스트 통과
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        // 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // (x, y, depth)
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int depth = now[2];
            
            // 목적지 도착
            if (x == n - 1 && y == m - 1) return depth;
            
            // 4방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                // 범위 벗어나면 패스
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                // 벽이거나 방문한 곳이면 패스
                if (maps[nx][ny] == 0 || visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, depth + 1});
            }
        }
        
        return -1; // 도달 불가
    }
}