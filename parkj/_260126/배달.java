import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] dist = new int[N+1][N+1]; // 거리 (제로베이스 인덱싱으로 인해 +1)
        int answer = 0;
        
        // 길 만들기
        //  i == j : 자기 자신한테 가는 것을 의미 하기에, 0으로 표기
        /// i != j : 자기와 다른 마을로 가는 것을 의미 하기에, (K 범위 + 1)으로 표기
        /// 해당 값은 점진적으로 최단 거리를 찾기 위함으로, 최악의 경우가 발생하는 일이 없게 만듦
        /// ex. A가 B한테 가는 거리가 500000(= K)
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = i == j ? 0 : 500001;
            }
        }

        // 최단 경로 저장 (단일, A -> B)
        /// ex. 입출력 예시 #2 [3,5,2],[3,5,3]
        /// 500001 > 2 => dist[3][5] = 2
        /// 2 < 3 => dist[3][5] = 2
        /// if문 조건으로 가장 짧은 경로를 지속적으로 갱신
        for (int[] r : road) {
            int v1 = r[0], v2 = r[1], w = r[2];
            if (w < dist[v1][v2]) {
                // 양방향 저장
                dist[v1][v2] = w;
                dist[v2][v1] = w;
            }
        }

        // 최단 경로 저장 (복합, A -> C -> B)
        for (int k = 1; k <= N; k++) { // k : 거쳐가는 마을
            for (int i = 1; i <= N; i++) { // i : 출발 마을
                for (int j = 1; j <= N; j++) { // j : 도착 마을
                    // (i -> j) vs {(i -> k) + (k -> j)} 거리 비교
                    // 우회가 더 빠르면? = 거쳐가는게 최단 경로가 됨
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        /// 문제에서 "1번 마을"을 기준으로 두고 있기에,
        /// 시작 지점을 1로 두고 거리가 K 이하인 곳만 증감한다.
        for (int i = 1; i <= N; i++) {
            if (dist[1][i] <= K) answer++;
        }

        return answer;
    }
}
