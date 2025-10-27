package _251027.programmers;

public class N개의_최소공배수__풀이1 {
    class Solution {
        public int solution(int[] arr) {
            // 최대공약수 : 1부터 1씩 올리기 + 모든수 % n ==0에서 갱신
            // 최소공배수 : 공약수 이용해서 계산

            int maxNum = 1;
            for (int n = 1; n <= 100; n++) {
                boolean can = true;
                for (int i : arr) {
                    if(i%n != 0) {can = false; break;}
                }
                if(can) maxNum = n;
            }

            int minNum = maxNum;
            for (int n : arr) {
                minNum *= n/maxNum;
            }

            return minNum;
        }
    }
}
