class Solution {
    public int solution(String s) {
        int answer = 0;
        int xCount = 0; // x 글자 횟수
        int notxCount = 0; // x 글자가 아닌 횟수
        char x = 0;

        for (int i = 0; i < s.length(); i++) {
            // 초기
            if (xCount == 0) {
                x = s.charAt(i);
                xCount++;
            // 문자열 왼쪽 -> 오른쪽으로 읽는중
            } else {
                if (s.charAt(i) == x) xCount++; // x 글자 발견
                else notxCount++; // 다른 글자 발견
            }

            // 두 횟수가 같다면, 분리
            if (xCount == notxCount) {
                answer++;
                xCount = 0;
                notxCount = 0;
            }
        }

        // 마지막 문자열 처리 (for문에서 끝나고 처리되지 못한 나머지)
        if (xCount != 0) answer++;

        return answer;
    }
}
