package _251021.programmers;

public class 덧칠하기__풀이1 {
    public int solution(int n, int m, int[] section) {
        // 1미터 단위 구역 1~n번까지
        // 롤러길이 m
        // 0 - - - - 0 /  0 0 0 0 - 0  / 0 --
        // 0 - - - - / 0 0 0 0 0 / - 0 0 -- => 순서대로하나, 중간을 끊나 똑같음

        int answer = 0;

        if (m == 1) return n;
        for (int i = 0; i < section.length; i++) {
            int j = 1;
            while (i + j < section.length - 1) {
                if (section[i+j] - section[i] == m-1) {i += j-1; break;} // 딱맞
                else if (section[i+j] - section[i] > m-1) {i += j-2; break;} // 초과
                else {j++;} // 부족
            }
            answer++;
        }

        return answer;
    }
    // 오답 + 일부 시간초과
}
