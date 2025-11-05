class Solution {
    public int solution(int number, int limit, int power) {
        // 약수의 개수를 구하고 
        
        int iron_weight = 0;
        
        // 각 기사단원의 숫자를 순회
        for(int i=1; i<=number; i++) {
            iron_weight += countDivisors(i, limit, power);
        }
    
        return iron_weight;
    }
    
    // 약수의 개수 리턴 함수
    private int countDivisors(int num, int limit, int power) {
        
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) count++;
            else if (num % i == 0) count += 2;
        }
        
        // 공격력 제한 수치 넘는다면
        if(count > limit) count = power;
        
        return count;
    }
}

// https://chwan.tistory.com/entry/Java-%EC%95%BD%EC%88%98%EC%9D%98-%EA%B0%9C%EC%88%98-%EA%B5%AC%ED%95%98%EA%B8%B0