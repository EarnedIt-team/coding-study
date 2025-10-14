package _251014.programmers;

// test case 7부터 실패, 시간초과 아님

public class 피보나치_수_풀이2 {
    public int solution(int n) {

        long[] fibo = new long[n + 1];

        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        return (int)fibo[n] % 1234567;
    }
}
