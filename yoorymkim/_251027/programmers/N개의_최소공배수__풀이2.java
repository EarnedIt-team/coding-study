package _251027.programmers;

public class N개의_최소공배수__풀이2 {
    class Solution {
        public int solution(int[] arr) {
            // 최대공약수 : 1부터 1씩 올리기 + 두수 % n ==0에서 갱신
            // 최소공배수 : 두수씩 최대공배수 구하기 반복으로 갱신

            int minNum = arr[0];
            for (int i = 1; i < arr.length; i++) {
                minNum = minNum * arr[i] / getTwoNumMax(minNum, arr[i]);
            }

            return minNum;
        }

        private int getTwoNumMax(int i, int j) {
            int maxNum = 1;
            for (int n = 1; n <= 100; n++)
                if(i%n == 0 && j%n == 0) maxNum = n;
            return maxNum;
        }
    }
}
