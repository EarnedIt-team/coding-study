package _251014.programmers;

import java.util.*;

public class 최대공약수와_최소공배수 {
    public long[] solution(int n, int m) {
        // 18, 42 -> {6, 6 * (18/6) * (42/6)}

        long[] answer = new long[2];
        int smaller = Math.min(n,m);

        for (int i = 1; i <= smaller; i++) {
            if (n%i == 0 && m%i == 0) answer[0] = i;
        }

        //answer[1] = answer[0] * (n/answer[0]) * (m/answer[0]);
        answer[1] = n * (m / answer[0]);

        return answer;
    }
}
