import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        /// 순서가 중요한가? = 문제에서 제한사항으로 두지않음
        /// 가장 많은 적을 우선적으로 처리하고 후에 별도의 조건을 걸어 해결
        // 가장 많은 적을 위한 내림차순 Queue
        PriorityQueue<Integer> bigEnemyQueue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        // 라운드 진행
        for (int e : enemy) {
            bigEnemyQueue.offer(e); // 현재 라운드 적 저장

            // 병사가 충분한 경우 (그냥 통과, 무적권 쓸 필요가 X)
            if (n - e >= 0) {
                n -= e;
            }
            // 병사가 부족한 경우
            else {
                // 무적권 사용 가능
                if (k > 0 && !bigEnemyQueue.isEmpty()) {
                    n += bigEnemyQueue.poll(); // 무적권으로 인해 적 처리
                    k--; // 무적권 카운트 감소
                    n -= e; // 현재 라운드 병사 소모
                } else {
                    break; // 더 이상 진행 불가
                }
            }

            answer++; // 라운드 통과
        }

        return answer;
    }
}
