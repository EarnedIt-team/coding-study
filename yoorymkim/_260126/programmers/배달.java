package _260126.programmers;

import java.util.*;

public class 배달 {
    class Solution {
        public int solution(int N, int[][] road, int K) {
            // 맵 안의 맵(중첩맵) : key:시작노드 -> val:map<key:끝노드 -> val: 비용>
            HashMap<Integer, Map<Integer, Integer>> map = new HashMap<>();

            // 중첩맵에 간선정보 저장
            for (int[] eachRoad : road) {
                map.computeIfAbsent(eachRoad[0], k -> new HashMap<>());
                Map<Integer, Integer> valMap = map.get(eachRoad[0]);
                if (!valMap.containsKey(eachRoad[1]) || valMap.get(eachRoad[1]) > eachRoad[2]) {
                    valMap.put(eachRoad[1], eachRoad[2]); // 최저비용 간선만 저장
                }

                // 양방향 간선 => 반대방향도 저장
                map.computeIfAbsent(eachRoad[1], k -> new HashMap<>());
                valMap = map.get(eachRoad[1]);
                if (!valMap.containsKey(eachRoad[0]) || valMap.get(eachRoad[0]) > eachRoad[2]) {
                    valMap.put(eachRoad[0], eachRoad[2]);
                }
            }


            // 1번 -> 각 노드 탐색 시작 ~~~

            int[] minCost = new int[N + 1]; // 1->i노드까지 가는 최소비용
            Arrays.fill(minCost, Integer.MAX_VALUE); // 배열값 초기화
            minCost[1] = 0; // 1->1은 비용 0

            // 우선순위 큐. val:{노드번호, 현재누적비용}
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> Integer.compare(a[1], b[1]) // 비용이 작은 것부터 꺼냄
            );

            pq.offer(new int[]{1, 0}); // 시작점 1번, 1->1비용은 0

            while (!pq.isEmpty()) {
                int[] current = pq.poll(); // 현재 발견경로 중 비용이 min인 노드 꺼냄

                int nowNode = current[0]; // 현재 노드
                int totalCost = current[1]; // 1번->현재노드까지 비용

                // 이미 더 짧은 경로발견 되어있으면 탐색x
                if (totalCost > minCost[nowNode]) continue;

                // 현재노드에서 갈수있는 모든 노드 탐색
                Map<Integer, Integer> nextNodes = map.get(nowNode);
                for (Map.Entry<Integer, Integer> entry : nextNodes.entrySet()) {
                    int nextNode = entry.getKey();
                    int nextCost = totalCost + entry.getValue();

                    // 지금 이 경로가 기존 경로보다 짧다면 갱신
                    if (nextCost < minCost[nextNode]) {
                        minCost[nextNode] = nextCost;
                        pq.offer(new int[]{nextNode, nextCost});
                    }
                }
            }

            int answer = 0;
            for (int i = 1; i <= N; i++) {
                if (minCost[i] <= K) {
                    answer++;
                }
            }

            return answer;
        }
    }

}
