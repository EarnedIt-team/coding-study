import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        // 아래 두 조건 중 하나 만족하는 가장 큰 양의 정수 a
        // 철수 카드들 모두 나눌 수 있고, 영희꺼는 무엇도 나눌 수 없는 양의 정수 a
        // 영희 카드들 모두 나눌 수 있고, 철수꺼는 무엇도 나눌 수 없는 양의 정수 a
        
        // arrayA, arrayB 길이 500,000
        // 중복된 원소 있을 수 있음
        
        int answer = 0;
        
        // 0번째 원소 저장
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        // 최대공약수 구하기
        for(int i = 0; i < arrayA.length; i++) {
            gcdA = getGCD(gcdA, arrayA[i]);
            gcdB = getGCD(gcdB, arrayB[i]);
        }
        
        // arrayA의 최대공약수가 1이 아니라면
        if(gcdA != 1) {
            boolean valid = true;
            for (int num : arrayB) {
                if (num % gcdA == 0) { // 나눠지는 게 하나라도 있으면 무효
                    valid = false;
                    break;
                }
            }
            if (valid) answer = Math.max(answer, gcdA);
        } 
        
        // arrayB의 최대공약수가 1이 아니라면
        if(gcdB != 1) {
            boolean valid = true;
            for (int num : arrayA) {
                if (num % gcdB == 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) answer = Math.max(answer, gcdB);
        }
        
        return answer;
    }
    // 유클리드 호제법
    int getGCD (int x, int y) {
        if(y == 0) return x;
        return getGCD(y, x % y); 
    }
}