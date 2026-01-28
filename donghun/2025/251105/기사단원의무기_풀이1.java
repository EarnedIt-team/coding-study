// 풀이 1 - 실패 (일부 시간 초과)
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
        
        for(int i = 1; i <= num; i++) {
            if(num % i == 0) {
                count++;
            }
        }
        
        // 공격력 제한 수치 넘는다면
        if(count > limit) count = power;
        
        return count;
    }
}