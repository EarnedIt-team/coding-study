package _251014.programmers;

// test case 7부터 시간초과

public class 피보나치_수_풀이1 {
    public int solution(int n) {

        long answer = fibo(n) % 1234567;
        return (int) answer;

    }

    private long fibo(long n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibo(n - 1) + fibo(n - 2);

    }
}
