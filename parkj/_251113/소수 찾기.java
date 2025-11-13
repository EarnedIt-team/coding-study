class Solution {
    public int solution(int n) {   
        int answer = 0; // 소수 개수
        
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true; // 소수 여부
            
            // 제곱근까지 검사 (성능 최적화)
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            // 만약 소수라면 +1
            answer += isPrime ? 1 : 0;
        }
        
        return answer;
    }
}
