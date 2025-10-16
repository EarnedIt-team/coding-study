class Solution {
    public int solution(int[] arr) {
        
        int result = arr[0];
        for(int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        
        return result;
    }

    // 유클리드 호제 방법으로 최대공약수 구하기 GCD
    int getGCD(int a, int b) {
        if(b == 0) return a;
        return getGCD(b, a%b);
    }
    
    // 최소 공배수 구하기
    int lcm(int a, int b) {
        return a * b / getGCD(a, b);
    }
    
}