/// 문자열로 검사하는 대신, 문자 단위로 분리해서 검사하는 방식으로 변경
/// 공백이 나타난 이후로, 문자열이 나타남으로 다음 글자는 대문자로 변경 할 수 있게 boolean 값을 설정
/// (공백 이후에 연속으로 공백이 나올 수 있지만, if문으로 인해 다음 문자열이 나타날 때까지 true값을 유지함)

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isChangeUpper = true; // 다음 글자를 대문자로 변환할지 여부

        // 문자 단위로 하나씩 검사
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 문자가 공백이라면,
            if (c == ' ') {
                answer.append(c); // answer 문자열에 공백을 추가
                isChangeUpper = true; // 다음 글자는 대문자로 변경한다고 설정
            // 문자가 공백이 아니라면,
            } else {
                // 대문자로 변경하기로 설정했다면,
                if (isChangeUpper) {
                    answer.append(Character.toUpperCase(c)); // answer 문자열에 대문자 추가
                    isChangeUpper = false; // 다음 글자는 소문자로 변경
                } else {
                    answer.append(Character.toLowerCase(c)); // answer 문자열에 소문자 추가
                }
            }
        }

        return answer.toString();
    }
}
