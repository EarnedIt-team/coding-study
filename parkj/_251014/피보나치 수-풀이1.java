/// 1234567으로 나눈 나머지를 리턴..?
/// 일단 재귀 호출로 만들어서 피보나치를 구현
/// 물론 테스트 6번 부터 시간 초과 발생 (정답률 42.9%)

class Solution {
    public int solution(int n) {
        int answer = pivo(n-1) + pivo(n-2);
        return answer;
    }
    
    private int pivo(int k) {
        if (k == 0) return 0;
        else if (k == 1) return 1;
        else return pivo(k-1) + pivo(k-2);
    }
}