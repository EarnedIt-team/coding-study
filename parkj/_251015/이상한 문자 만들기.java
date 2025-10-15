class Solution {
    public String solution(String s) {
        // 문자열 기준이 아니라, "단어" 기준으로 인덱스를 판단
        // 즉, 공백은 인덱스에 포함시키지 않는다는 의미
        
        int index = 0;
        StringBuilder answer = new StringBuilder();
        
        for (char chr : s.toCharArray()) {
            if (chr == ' ') {
                answer.append(chr);
                index = 0; // 공백 이후에 단어가 나타나기에, index 초기화
            } else {
                // 짝수는, 대문자
                if (index % 2 == 0) {
                    answer.append(Character.toUpperCase(chr));
                } else {
                    // 홀수는 소문자
                    answer.append(Character.toLowerCase(chr));
                }
                index++;
            }
        }
        
        return answer.toString();
    }
}
