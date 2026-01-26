import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        // 1번 마을 기준으로 음식 배달 가능 마을 개수 리턴
        // 1번 key 값에 value는 int[] {대상 마을, 거리}
        // 문제 예시 2처럼 같은 마을을 잇는 경로가 2개인 경우는 더 짧은 경우만 저장
        
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        // map에 거리 정보 기록
        for(int i = 0; i < road.length; i++) {
            int[] info = road[i];
            int target = info[1];
            int dist = info[2];
            
            // 양방향 추가
            // 존재하지 않는다면 리스트를 생성해서 add 
            map.computeIfAbsent(info[0], k -> new ArrayList<>())
                                            .add(new int[]{target, dist});
            map.computeIfAbsent(target, k -> new ArrayList<>())
                                            .add(new int[]{info[0], dist});
        }
        
        // 확인
        for(Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            List<int[]> list = entry.getValue();
            
            System.out.println("key :" + entry.getKey());
            for(int i = 0; i < list.size(); i++) {
                System.out.println("value :" + "[" + list.get(i)[0] + "," + list.get(i)[1] + "]");
            }
        }
        
        // 1번 키값의 value리스트의 value[0] 값들을 가져옴
        // 해당 target들로부터 이어지는 다음 경로들을 가져옴
        // 이 때, 문제에서 주어진 K시간보다 짧다면 answer++하고 초과한다면 더이상 탐색하지 않도록 함
        
        // 1번 마을 기준 최단거리 배열
        int[] distArr = new int[N + 1];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[1] = 0;

        // {마을, 거리}, 거리 기준 오름차순 정렬
        PriorityQueue<int[]> pq = 
            new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0});

        // 다익스트라
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curVillage = cur[0];
            int curDist = cur[1];

            // 이미 더 짧은 경로가 있으면 스킵
            if (curDist > distArr[curVillage]) continue;

            // 현재 마을에서 갈 수 있는 다음 경로들
            for (int[] next : map.getOrDefault(curVillage, Collections.emptyList())) {
                int nextVillage = next[0];
                int nextDist = curDist + next[1];

                if (nextDist < distArr[nextVillage]) {
                    distArr[nextVillage] = nextDist;
                    pq.offer(new int[]{nextVillage, nextDist});
                }
            }
        }

        // K시간 이하로 배달 가능한 마을 카운트
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (distArr[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}