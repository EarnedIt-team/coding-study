import java.util.*;

class Solution {
    // union-find의 부모 배열: parent[i]는 i의 대표(루트)를 가리킨다.
    int[] parent;
    // 각 루트(대표)에 속한 노드 개수를 세기 위한 배열
    int[] count;
    
    /// 1. union으로 노드들을 하나의 집합으로 묶기
    /// 2. find로 각 노드가 어느 집합에 속했는지 확인
    /// 3. 그 결과로 count에 집합 크기를 카운팅
    
    public int solution(int n, int[][] wires) {
        // 정답 초기화: 최댓값으로 n을 사용 (두 부분의 차이는 n을 넘을 수 없음)
        int answer = n;

        // 모든 전선을 하나씩 "제거 후보"로 해본다
        for (int i = 0; i < wires.length; i++) {

            // ---- 배열 초기화 ----
            // 1부터 n까지 자기 자신을 부모로 세팅(각 노드는 독립 집합)
            parent = new int[n + 1];
            for (int j = 1; j <= n; j++) parent[j] = j;

            // ---- i번 전선을 제외한 나머지 전선들로 union 수행 ----
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; // i번 전선은 제거(무시)

                int a = wires[j][0];
                int b = wires[j][1];
                union(a, b); // a와 b를 같은 집합으로 합침
            }

            // ---- 각 집합(루트)의 크기 계산 ----
            // count[root] 에 root에 속한 노드 수를 누적
            count = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                int root = find(j); // j가 속한 집합의 대표(루트)를 찾음
                count[root]++;      // 해당 루트의 개수 1 증가
            }

            // ---- 두 그룹의 크기만 뽑아 차이를 계산 ----
            List<Integer> group = new ArrayList<>();
            for (int c : count) if (c > 0) group.add(c); // 존재하는 그룹만 수집

            // 문제 조건상 항상 정확히 2개의 그룹이 만들어짐(전선 하나 제거)
            int diff = Math.abs(group.get(0) - group.get(1));
            // 최솟값 갱신
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    // ---- 대표(루트)를 찾기 ----
    int find(int x) {
        if (parent[x] == x) return x;          // 자기 자신이 루트면 반환
        return parent[x] = find(parent[x]);    // 재귀로 부모를 타고 올라가며 경로 압축
    }

    // ---- 두 집합을 합치기 ----
    void union(int a, int b) {
        int pa = find(a); // a의 루트
        int pb = find(b); // b의 루트
        if (pa != pb) parent[pb] = pa; // 두 루트가 다르면 pb를 pa에 붙여 합침
    }
}
