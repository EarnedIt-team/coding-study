class Solution {
    public String solution(int n, int t, int m, int p) {
        String allString = "", answer = "";
        int num = 0;
        
        // 현재 게임에서 나올 수 있는 모든 숫자 : 미리 구할 숫자 개수 (t) * 인원 (m)
        while (allString.length() < t * m) {
            // 영문자는 문제 조건에서 "대문자"로 표시
            allString += Integer.toString(num++, n).toUpperCase();
        }
        
        // 내 차례(p)에 해당하는 문자만 가져오기
        for (int i = 0; i < t; i++) {
            answer += allString.charAt((p - 1) + (i * m));
        }
        
        return answer;
    }
}
