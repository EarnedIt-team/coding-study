/// 정확성 테스트에서는 모두 통과하나 효율성 테스트 5,6번에서 실패(시간 초과)가 발생함.
/// 확인해본 결과, while문을 통해서 찾지못하면 매번 전체 문자열을 순회(for)하고 StringBuilder를 사용해서 문자열을 반복적으로 수정하니
/// n이 커질수록 시간 복잡도가 기하급수적으로 늘어나는 현상으로 파악됨.

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int binary_Number = n;
        
        // n을 2진수로 변환
        while (binary_Number > 0) {
            sb.append(binary_Number % 2);
            binary_Number /= 2;
        }

        // 2진수의 "1" 카운트
        int count_Bit = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') count_Bit++;
        }

        // 자연수 n 다음의 숫자가 조건에 맞을때까지 무한 반복
        while (true) {
            int i = 0;
            while (true) {
                if (i == sb.length()) {
                    // 전부 1이었던 경우 → 자릿수 추가
                    sb.append('1');
                    break;
                }

                if (sb.charAt(i) == '0') {
                    // 0이라면 1로 변환하고 중단
                    sb.setCharAt(i, '1');
                    break;
                } else {
                    // 1이라면 0으로 변환하고 다음자리로 이동
                    sb.setCharAt(i, '0');
                    i++;
                }
            }

            // "1" 개수가 일치하는지 검사
            int new_Count_Bit = 0;
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == '1') new_Count_Bit++;
            }

            if (new_Count_Bit == count_Bit) {
                // 뒤집어서 정수로 변환
                sb.reverse();
                answer = Integer.parseInt(sb.toString(), 2);
                return answer;
            }
        }
    }
}
