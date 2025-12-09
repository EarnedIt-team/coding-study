package _251208.programmers;

public class 땅따먹기_정답 {
    class Solution {
        int solution(int[][] land) {
            // 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없 -> 완탐해...? 그리디 안될거같은데
            // 역시나 그리디는 절대안되지만 완탐dfs 쓰고싶지 않음 .. 최선일거같지가 진짜 않음..
            // 각 행turn에서 각 열마다 그때까지 최댓값저장..? !!! 열이 4 고정임 !!!
            for (int i = 1; i < land.length; i++) {
                land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
                land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
                land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
                land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
            }

            int answer = 0;
            for (int i = 0; i < 4; i++) answer = Math.max(answer, land[land.length - 1][i]);

            return answer;
        }
    }

}
