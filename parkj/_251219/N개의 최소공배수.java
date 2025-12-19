class Solution {

    public int solution(int[] arr) {
        int answer = arr[0];
        
        // [2,6,8,14]
        // [2,6] 기준으로 최소공배수 찾기 => 이후 나온값은 a라고 가정
        // [a,8] 기준으로 최소공배수 찾기 => 이후 나온값은 b라고 가정
        // [b,14] 기준으로 최소공배수 찾기
        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }
    
    // 최소공배수 (LCM) : 두 수를 곱한 값 / 두 수의 최대공약수
    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // 최대공약수(GCD) (유클리드 호제법)
    int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
