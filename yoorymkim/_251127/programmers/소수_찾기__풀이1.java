package _251127.programmers;

import java.util.*;

public class 소수_찾기__풀이1 {

    class Solution {

        HashSet<Integer> set = new HashSet<>(); //모든 경우의 수 저장
        boolean[] visited;
        char[] arr;

        public int solution(String numbers) {
            // 나오는 숫자 중복 가능 -> 숫자 섞는 모든 경우의 수 저장 후 해시셋으로 중복 거르기
            // 011 -> 1(=01) / 10(=010), 11(=011) / 101, 110 <<= 자릿수별로 조합시 첫자리 0처리? ,, ㅇ므
            // -> String parseInt로 앞자리 0 날리기 <= int[] 말고 char[], 먼저 String만들기!
            // 모든 경우의 수 -> 모든 경우의 수 뽑고 섞기 :: 순열

            int len = numbers.length();
            arr = numbers.toCharArray();
            visited = new boolean[len];

            dfs("", 0);

            int answer = 0;
            for (int num : set) {
                if (isPrime(num)) answer++;
            }

            return answer;
        }

        // 순열 알고리즘
        private void dfs(String current, int depth) {
            if (current.length() > 0) {
                set.add(Integer.parseInt(current));
            }

            if (depth == arr.length) return;

            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(current + arr[i], depth + 1);
                    visited[i] = false;
                }
            }
        }

        // 소수인가
        private boolean isPrime(int n) {
            if (n < 2) return false; // 0,1 소수아님
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }

}
