class Solution {
    public String solution(int n) {
        // 숫자는 3개뿐이니, 3을 나눈 나머지 값을 이용해서 순서대로 값을 붙여주면 되는구조
        // 모듈러 연산(%) 방식으로 처리할 때, 순서는 다음과 같습니다.
        // n = 1, n % 3 = 1 -> "1"
        // n = 2, n % 3 = 2 -> "2"
        // n = 3, n % 3 = 0 -> "4"
        String[] rules = {"4", "1", "2"};
        String answer = "";

        // 10진법 -> 124 나라 변환
        while (n > 0) {
            int remain = n % 3; // 나머지 값 구하기 (rules 인덱스 결정)
            n /= 3; // 몫 구하기
            
            // 자릿수 올림 보정
            // ex. n = 3, n % 3 = 0 (즉, 인덱스가 0인 "4"가 선택됨)
            // n /= 3 으로 인해 0으로 되지않고 1로 다시 한번 while문을 돌게 됨
            // 다음 while문에서 계산할 몫에서 -1 해서 올림을 보정해준다.
            if (remain == 0) n--;

            /// 5 % 3 = 2 (=> 인덱스가 2인 "2"가 선택됨)
            /// 5 / 3 = 1
            /// 1 % 3 = 1 (=> 인덱스가 1인 "1"가 선택됨)
            /// 5 = 12
            answer += rules[remain];
        }
        
        // 새로운 숫자는 "앞"에 붙어야 하기에 마지막에 뒤집어줌
        return new StringBuilder(answer).reverse().toString();
    }
}
