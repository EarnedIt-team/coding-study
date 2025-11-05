class Solution {
    public int solution(int number, int limit, int power) {
        // 기사단원 수 : number
        // 공격력 제한수치 : limit
        // 제한수치를 초과한 기사의 무기 공격력 : power
        int answer = 0;
        
        int[] measure = new int[1+number]; // 1부터 ~ number까지

        // 모든 수의 약수의 개수 구하기
        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j += i) {
                measure[j]++; // i는 j의 약수이므로 +1
            }
        }
        
        // 약수의 개수에 따라 철의 무게 합을 결정
        for (int k = 0; k < measure.length; k++) {
            // 만약, 약수의 개수가 제한 수치(limit)를 넘는다면 power값만 이용
            answer += measure[k] > limit ? power : measure[k];
        }
        
        return answer;
    }
}
