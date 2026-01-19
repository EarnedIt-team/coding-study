class Solution {
    int count = 0;
    
    public int solution(int n, int k) {    
        // n -> K진수로 변환한 값을 0을 기준으로 분리해서 순차적으로 검사
        // 0+ : 0이 "하나 이상"을 기준으로 처리 (= 연속적으로 붙음
        for (String str : Integer.toString(n, k).split("0+")) {
            // 소수 판별 (int 범위를 넘을 수도 있어서 Long 처리)
            isPrime(Long.parseLong(str));
        }
        
        return count;
    }

    // 소수 판별 (제곱근까지)
    void isPrime(long num) {
        if (num < 2) return; // 1은 소수가 아님
        if (num == 2) { count++; return; } // 2는 소수
        
        // 제곱근까지 나누어 떨어지는지 확인
        for (long i = 2; i <= (long) Math.sqrt(num); i++) {
            if (num % i == 0) return;
        }
        
        count++;
    }
}
