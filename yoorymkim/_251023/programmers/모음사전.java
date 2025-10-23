package _251023.programmers;

public class 모음사전 {
    private static final char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    private static final int[] weights = new int[5]; // 각 자리 가중치 저장

    public int solution(String word) {
        // 가중치 계산
        initWeights();

        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            int idx = getCharIndex(word.charAt(i)); // A,E,I,O,U 중 해당 문자의 인덱스 (0~4)

            // 현재 자리의 가중치만큼 더하기
            // 첫 글자가 E 라면 -> (1 * 781) + 1
            answer += idx * weights[i] + 1;
        }

        return answer;
    }

    // 각 자리별 가중치 계산 메서드
    private void initWeights() {
        int w = 0;
        for (int i = 4; i >= 0; i--) {
            w = w * 5 + 1; // 5진수 누적: (5^0 + 5^1 + ... + 5^(4-i))
            weights[i] = w;
        }
    }

    // 문자가 A,E,I,O,U 중 몇 번째인지 반환
    private int getCharIndex(char c) {
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == c) return i;
        }
        return -1; // 없을 리는 없음
    }
}
