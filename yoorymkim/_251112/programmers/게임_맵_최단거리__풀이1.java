package _251112.programmers;

import java.util.*;

public class 게임_맵_최단거리__풀이1 {

    class Solution {
        public int solution(int[][] maps) {
            // 0,0 -> n-1,m-1 / 1칸씩 이동하며 넓이우선탐색
            // 최소거리는 갔던 길 되돌아가지 않음
            int n = maps.length; // 세로 길이
            int m = maps[0].length; // 가로 길이
            return bfs(maps, n, m); // BFS로 최단거리 계산
        }

        private int bfs(int[][] maps, int n, int m) {
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{0, 0}); // 시작 좌표
            maps[0][0] = 0; // 방문o

            int[][] dist = new int[n][m]; // 거리 저장 배열
            dist[0][0] = 1; // 시작칸 거리 == 1

            while (!q.isEmpty()) {
                int[] cur = q.poll(); // 현재 좌표
                int x = cur[0], y = cur[1];

                if (x == n - 1 && y == m - 1) return dist[x][y]; // 도착일 경우

                // 상
                if (x - 1 >= 0 && maps[x - 1][y] == 1) {
                    maps[x - 1][y] = 0; // 방문o
                    dist[x - 1][y] = dist[x][y] + 1; // 거리 +1
                    q.offer(new int[]{x - 1, y});
                }

                // 하
                if (x + 1 < n && maps[x + 1][y] == 1) {
                    maps[x + 1][y] = 0;
                    dist[x + 1][y] = dist[x][y] + 1;
                    q.offer(new int[]{x + 1, y});
                }

                // 좌
                if (y - 1 >= 0 && maps[x][y - 1] == 1) {
                    maps[x][y - 1] = 0;
                    dist[x][y - 1] = dist[x][y] + 1;
                    q.offer(new int[]{x, y - 1});
                }

                // 우
                if (y + 1 < m && maps[x][y + 1] == 1) {
                    maps[x][y + 1] = 0;
                    dist[x][y + 1] = dist[x][y] + 1;
                    q.offer(new int[]{x, y + 1});
                }
            }

            return -1; // 도착 불가
        }
    }
}
