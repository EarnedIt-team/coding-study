package _251015.programmers;

public class 서버_증설_횟수 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int active = 0; // 현재 기준 운영중 서버개수
        int[] expire = new int[24]; // 만료 시간 //최대 24 + k

        for (int h = 0; h < 24; h++) {
            active -= expire[h]; // 반납

            int need = players[h] / m; // 필요량 올림연산 해야함
            if (need > active) {
                int x = need - active;
                answer += x;
                active += x;
                if (h + k < 24) expire[h + k] += x; // 만료 시간에 넣어두기
            }
        }

        return answer;
    }
}
