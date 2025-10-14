class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        // 무차별 대입
        /// 나올 때 까지 처음부터 끝까지 찾음 (m이 가장 두 수중에 가장 큰 값이라고 가정)
        for (int i=1; i<=m; i++) {
            // 두 수의 나머지가 0이라면
            if (n%i == 0 && m%i == 0) {
                answer[0] = i; // 공약수
                answer[1] = n * m / i; // 공배수
            }
        }
        
        return answer;
    }
}