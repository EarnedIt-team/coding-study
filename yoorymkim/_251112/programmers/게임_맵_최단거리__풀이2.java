package _251112.programmers;

import java.util.*;

public class 게임_맵_최단거리__풀이2 {

    class Solution {
        public int solution(int[][] maps) {
            // 0,0 -> n-1,m-1 / 1칸씩 이동하며 넓이우선탐색
            // 최소거리는 갔던 길 되돌아가지 않음

            int n = maps.length; // 세로 길이
            int m = maps[0].length; // 가로 길이
            return bfs(maps, n, m); // BFS로 최단거리 계산
        }

        private int bfs(int[][] maps, int n, int m) {
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{0, 0}); // 시작 좌표
            maps[0][0] = 0; // 방문o

            int[][] dist = new int[n][m]; // 거리 저장 배열
            dist[0][0] = 1; // 시작칸 거리 == 1

            while (!q.isEmpty()) {
                int[] cur = q.poll(); // 현재 좌표
                int x = cur[0], y = cur[1];

                if (x == n - 1 && y == m - 1) return dist[x][y]; // 도착일 경우

                for (int d = 0; d < 4; d++) { // 4 direction (상하좌우)
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // 유효 범위 && 1일때 이동
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1) {
                        maps[nx][ny] = 0; // 방문o
                        dist[nx][ny] = dist[x][y] + 1; // 거리 +1
                        q.offer(new int[]{nx, ny}); // 다음 칸 추가
                    }
                }
            }

            return -1; // 도착 불가
        }
    }
}
