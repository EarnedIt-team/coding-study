import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] user = {
            {1, 2, 3, 4, 5}, // 1번 수포자 패턴
            {2, 1, 2, 3, 2, 4, 2, 5}, // 2번 수포자 패턴
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} // 3번 수포자 패턴
        };

        int[] score = new int[3];

        int i=0;
        for (int answer : answers) {
            if (answer == user[0][i % 5]) score[0]++; // 1번 수포자 정답
            if (answer == user[1][i % 8]) score[1]++; // 2번 수포자 정답
            if (answer == user[2][i % 10]) score[2]++; // 3번 수포자 정답
            i++;
        }
        
        // 최고 점수
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            if (score[j] == max) list.add(j + 1); // 가장 많은 문제를 맞춘 사람을 저장
        }
        
        // ArrayList -> 배열로 변환
        return list.stream().mapToInt(k -> k).toArray();
    }
}
