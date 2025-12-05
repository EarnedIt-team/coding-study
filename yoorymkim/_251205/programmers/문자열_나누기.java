package _251205.programmers;

public class 문자열_나누기 {
    class Solution {
        public int solution(String s) {
            // 굳이 문자열 실제분리할필요 x
            int answer = 0;

            char x = s.charAt(0);
            int xCnt = 0;int nCnt = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == x) xCnt++;
                else nCnt++;

                if (xCnt == nCnt) {
                    answer++;
                    xCnt = 0; nCnt = 0;

                    if (i + 1 < s.length()) x = s.charAt(i + 1);
                }
            }

            if (xCnt != 0 || nCnt != 0) answer++;

            return answer;
        }
    }

}
