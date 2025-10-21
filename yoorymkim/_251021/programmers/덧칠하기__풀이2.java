package _251021.programmers;

public class 덧칠하기__풀이2 {
    public int solution(int n, int m, int[] section) {
        // 1미터 단위 구역 1~n번까지
        // 롤러길이 m
        // 0 - - - - 0 /  0 0 0 0 - 0  / 0 --
        // 0 - - - - / 0 0 0 0 0 / - 0 0 -- => 순서대로하나, 중간을 끊나 똑같음

        int answer = 0;
        int painted = 0;

        for (int s : section) {
            if (s > painted) {
                painted = s + m - 1; // 1회 최대치 다 칠하기
                answer++;
            }
        }

        return answer;
    }
}
