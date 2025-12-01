package _251201.programmers;

public class 전력망을_둘로_나누기__풀이 {
    class Solution {
        boolean[] visited;
        int[][] wiress;
        int cut0;
        int cut1;

        public int solution(int n, int[][] wires) {
            // 그래프 문제 느낌 ~!
            // n : 전체 탑 개수, [v1, v2], 1 ≤ v1 < v2 ≤ n <- !! 편리해보이는 조건 !!
            // 하나를 끊으면 무조건 둘로 나뉨 -> 끊은 v1과 연결된 쪽 탐색해서 나온 개수 & 다른쪽은 n-그것

            wiress = wires;
            int answer = n;

            for (int i = 0; i < n - 1; i++) {
                int[] w = wires[i];

                visited = new boolean[n + 1];
                cut0 = w[0];
                cut1 = w[1];
                int cnt = dfs(w[0]); // 재귀 탐색

                int diff = Math.abs((n - cnt) - cnt);
                answer = Math.min(answer, diff);
            }

            return answer;
        }

        // 순회 DFS
        int dfs(int cur) {
            visited[cur] = true;
            int cnt = 1;

            for (int[] w : wiress) {
                // 끊은 전선이면 넘어감
                if ((w[0] == cut0 && w[1] == cut1) ||
                        (w[0] == cut1 && w[1] == cut0)) {
                    continue;
                }

                // 현재 노드와 연결된 노드 탐색
                if (w[0] == cur && !visited[w[1]]) {
                    cnt += dfs(w[1]);
                }
                else if (w[1] == cur && !visited[w[0]]) {
                    cnt += dfs(w[0]);
                }
            }

            return cnt;
        }
    }

}
