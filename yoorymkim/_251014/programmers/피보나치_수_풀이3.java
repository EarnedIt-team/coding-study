package _251014.programmers;

public class 피보나치_수_풀이3 {
    public int solution(int n) {

        // 재귀함수 -> 시간초과 : case7부터
        // 1차원 배열 + 1중 for문 -> 시간은 ok, but 실패 : case7부터

        // => case7부터 n이 핵커짐, 커질때 문제가 된다
        // => long 오버플로우?

        long[] fibo = new long[n + 1];

        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }

        return (int)fibo[n];
    }
}
