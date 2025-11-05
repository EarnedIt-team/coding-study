class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        // 1 2 3 "4" 5 6 "7" 8
        // ? 4 ? 7
        // 4 7
        
        // 다음 라운드 번호 = (현재 번호 + 1)
        // a 와 b는 "항상 이긴다" 라고 가정
        // 같은 번호가 될 때까지 라운드 진행
        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }
}
