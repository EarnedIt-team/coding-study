class Solution {
    public int solution(int[] players, int m, int k) {
        // 같은 시간대에 게임을 이용하는 사람이 m명당 + 서버 1대
        // m명 미만이라면 서버 증설 x
        // n x m명 이상 ~ (n + 1) x m명 미만 => 최소 n대
        // 한 번 증설하면 k시간 동안 운영
        
        int answer = 0;
        
        int[][] arr = new int[24][2]; // 0시에서 23시까지의 시간대별 길이에 맞게 배열 생성
        
        // [시간대, 현재 시간대의 서버 수]
        // {1, 0}, {2, 0}, ..., {24, 0}
        for (int i = 0; i < 24; i++) {
            arr[i][0] = i + 1; // 시간대
            arr[i][1] = 0;     // 현재 시간대의 서버 수
        }

        // 모든 시간대를 순차적으로 검사
        for (int j = 0; j < 24; j++) {
            // 현재 필요한 서버 수 계산
            int needServer = players[j] / m;

            // 현재 서버가 이미 충분히 운영 중이라면
            if (arr[j][1] >= needServer) {
                continue;   
            } else {
                // 부족한 서버 개수만큼 증설 (필요 개수 - 증설된 서버의 수 = 증설하는 서버 개수)
                int addServer = needServer - arr[j][1];
                answer += addServer;
                
                // 증설한 서버는 k시간 동안 유지
                // t < j+k : 현재 시간(j) + k시간까지 서버 유지
                // t < players.length : 즉, 24시를 넘기지 않기 위함 (24시 넘어간다고 다음날로 이전되는 조건이 X)
                for (int t = j; t < j+k && t < 24; t++) {
                    arr[t][1] += addServer;
                }
            }
        }
        
        return answer;
    }
}
