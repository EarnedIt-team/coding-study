package _251211.programmers;

public class _2_x_n_타일링 {
    class Solution {
        public int solution(int n) {
            // 마지막 칸을 세로 타일로 채우기 -> 남은 공간은 2*(n-1)
            // 마지막 두 칸을 가로 타일 2개 로 채우기 -> 남은 공간은 2*(n-2)
            // fivo...??

            int MOD = 1000000007;

            if (n == 1) return 1;
            if (n == 2) return 2;

            long[] fivo = new long[n + 1];
            fivo[1] = 1;
            fivo[2] = 2;

            for (int i = 3; i <= n; i++) {
                fivo[i] = (fivo[i - 1] + fivo[i - 2]) % MOD;
            }

            return (int) fivo[n];
        }
    }

}
