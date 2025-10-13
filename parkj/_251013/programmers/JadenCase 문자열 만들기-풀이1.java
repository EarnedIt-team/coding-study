/// 8번 케이스에서 실패 (정답률 94.4)
/// 확인해보니, "공백의 문자가 연속으로 나오는 경우가 존재"에서 해당 조건을 만족하지 못함

class Solution {
    public String solution(String s) {
        /// JadenCase : 모든 단어의 첫 문자가 "대문자" (나머지는 소문자)
        /// 다만, 첫 문자가 알파벳이 아니라면 그 다음 나타나는 알파벳을 소문자로 작성
        String answer = "";
        String[] strArr = s.split(" ", -1); // 연속 공백 유지
        
        for (String str : strArr) {
            // 만약, 공백이라면 다음 문자열로 넘김
            if (str.isEmpty()) { 
                answer += " "; 
                continue; 
            }
            // 해당 문자열의 첫 단어를 가져옴
            char first = str.charAt(0);
            // 새롭게 문자열을 정의
            String newStr = Character.toUpperCase(first) + str.substring(1).toLowerCase();
            // answer 문자열에 추가
            answer += newStr + " ";
        }
        
        return answer.trim(); // 마지막 공백 제거 (앞, 뒤)
    }
}
