import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        // 완호는 scores[0]
        int[] wanho = scores[0];
        int rank = 1; // 완호의 석차
        int maxSecondScore = 0; // 지금까지 확인한 사람 중 가장 높은 동료평가 점수
        
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // 근무태도 같으면 동료평가 오름차순
            return b[0] - a[0]; // 근무태도 내림차순
        });

        // 인사 평가
        for (int i = 0; i < scores.length; i++) {
            int[] currentScore = scores[i]; // 평가하는 사원의 점수
            
            // 비교해봤을 때, 탈락 대상인가?
            // 이미 정렬되어있기에 근무태도([0])는 따로 검증하지 않아도 됨
            // 다만, 동료평가([1])가 상대방이 높다면? 탈락
            if (currentScore[1] < maxSecondScore) {
                // 탈락한 사람이 완호라면
                if (currentScore[0] == wanho[0] && currentScore[1] == wanho[1]) return -1;
                continue; 
            }

            // 탈락자가 아니라면 동료평가 최댓값을 갱신
            maxSecondScore = Math.max(maxSecondScore, currentScore[1]);

            // 탈락하지 않았고, 완호보다 점수 합계가 높으면 완호 랭킹 하락
            if (currentScore[0] + currentScore[1] > wanho[0] + wanho[1]) {
                rank++;
            }
        }

        return rank;
    }
}
