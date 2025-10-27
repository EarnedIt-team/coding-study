class Solution {
    int answer = 0;
    int[] visitDungeon; // 던전 탐험 여부
    
    public int solution(int k, int[][] dungeons) {
        visitDungeon = new int[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }

    void dfs(int fatigue, int[][] dungeons, int count) {
        // dfs 함수가 매번 호출 될 때마다 탐험한 던전 수를 갱신
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {            
            // 탐험이 가능한 던전이라면
            if (visitDungeon[i] == 0) {
                // 현재 피로도(fatigue)가 최소 필요 피로도보다 같거나 많다면
                if (fatigue >= dungeons[i][0]) {
                    visitDungeon[i] = 1; // 던전 입장
                    dfs(fatigue - dungeons[i][1], dungeons, count + 1); // 해당 던전을 입장한 이세계 기준으로 dfs
                    
                    /// 백트래킹이 필요한 이유,
                    /// "모든 경우의 수"를 탐색해야되는데, 앞에서 수정한 값을 그대로 유지하면
                    /// 한 번 방문한 던전이 계속 방문된 상태로 남아 다른 조합을 탐색하지 못함
                    visitDungeon[i] = 0; // 던전 퇴장 (원상 복구, 백트래킹)
                }
            // 이미 탐험한 던전
            } else {
                continue;
            }
        }
    }
}
