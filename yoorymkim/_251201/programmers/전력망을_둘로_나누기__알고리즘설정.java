package _251201.programmers;

public class 전력망을_둘로_나누기__알고리즘설정 {
    class Solution {
        public int solution(int n, int[][] wires) {
            // 그래프 문제 느낌 ~!
            // n : 전체 탑 개수, [v1, v2], 1 ≤ v1 < v2 ≤ n <- !! 편리해보이는 조건 !!
            // 하나를 끊으면 무조건 둘로 나뉨 -> 끊은 v1과 연결된 쪽 탐색해서 나온 개수 & 다른쪽은 n-그것

            int answer = n;

            for (int i = 0; i < n-1; i++) {
                // 자를 애 : w[0] -> w 앞쪽배열[1]에 있기, w[1] -> w 뒷쪽배열[0]에 있기
                int[] w = wires[i];
                int cnt = 0;
                for (int j = 0; j < i; j++) { // 앞쪽 탐색
                    if (w[0] == wires[j][1]) { // 연결됨
                        for (int k = 0; k < j; k++) {
                            //... 재귀 탐색 반복, 나오면서 cnt 세기
                        }
                    }
                }
                cnt = Math.abs(cnt - (n - cnt));
                answer = Math.min(cnt, answer);
            }

            return answer;
        }
    }
}
