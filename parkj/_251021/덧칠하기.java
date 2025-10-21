class Solution {
    public int solution(int n, int m, int[] section) {
        // 현재 페인트가 진행된 길이를 기억하고 (brushDistance)
        // 새로 칠 해야되는 영역과 비교한다. (section)
        
        int answer = 0;
        int brushDistance = 0;
        
        for (int i = 0; i < section.length; i++){
            // 해당 구역은 이미 진행되었기에 넘김
            if (section[i] <= brushDistance) continue;

            // 내가 칠한 영역 : 시작점 + 붓 길이 - 1
            // 페인트는 오름차순이기에 시작점부터 기억하면 됨
            brushDistance = section[i] + m - 1;
            answer++;
        }

        return answer;
    }
}
