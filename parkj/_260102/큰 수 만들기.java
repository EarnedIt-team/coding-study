class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int index = 0;

        // return : 전체 길이 - 제거할 개수 k
        for (int i = 0; i < number.length() - k; i++) {
            char MaxNum = '0'; // 현재 자리에 올 수 있는 가장 큰 숫자
            
            // 현재 자리에서 선택 가능한 범위 : index ~ i + k
            for (int j = index; j <= i+k; j++) {
                // 현재 숫자가 이전에 찾은 최대값보다 크다면
                if (number.charAt(j) > MaxNum) {
                    MaxNum = number.charAt(j); // 갱신
                    
                    // 선택한 숫자 다음 위치부터 다시 탐색
                    // ex. 41"7"7 <- 3번째 7을 선택함
                    // 앞에 있던 41은 제거하고 다음 순서인 725... 부터 시작하게 됨
                    index = j+1;
                }
            }
            answer.append(MaxNum);
        }

        return answer.toString();
    }
}
