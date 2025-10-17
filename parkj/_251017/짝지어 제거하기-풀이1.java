/// 정답률 61.2% (효율성 0%)
/// 아무래도 매번 문자열을 수정하고 새로 다시 검사해서 시간이 늘어난거같다.

class Solution {
    public int solution(String s) {       
        StringBuilder sb = new StringBuilder(s);
        boolean removed = true; // 짝 제거가 일어났는지 체크
        int answer = -1;
        
        while (removed) {
            removed = false;
            char currentChr = '@';

            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == currentChr) {
                    // 짝 발견 → 두 문자 제거
                    sb.delete(i - 1, i + 1);
                    removed = true;
                    break; // 문자열이 바뀌었으니 처음부터 다시 검사
                }
                currentChr = sb.charAt(i);
            }
        }
        answer = sb.length() == 0 ? 1 : 0;

        return answer;
    }
}
