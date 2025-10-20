class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for (char chr : s.toCharArray()) {
            char nextChr = chr;
            
            if (chr == ' ') {
                answer += ' ';
                continue;
            }
            
            /// 알파벳은 26자리
            /// n만큼 밀어도 그 문자열에서 순환함
            /// 'z'를 1만큼 민다면 다시 원점으로 돌아온 'a'
            /// 'z'를 4만큼 민다면 원점 'a'로 돌아와서 'd'
            /// 소문자 / 대문자까리 순환한다. (소문자 -> 대문자, 대문자 -> 소문자로 변환 X)
            else if (chr >= 'a' && chr <= 'z') {
                nextChr = (char)('a' + (chr - 'a' + n) % 26);
            }
            else if (chr >= 'A' && chr <= 'Z') {
                nextChr = (char)('A' + (chr - 'A' + n) % 26);
            }    
            
            answer += nextChr;
        }
        
        return answer;
    }
}
