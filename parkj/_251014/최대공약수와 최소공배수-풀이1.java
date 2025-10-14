class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int n2 = n;
        int m2 = m;
        
        // 유클리드 호제법 : 두 수가 서로 상대방 값을 나눠서 값을 구함
        while (m2 != 0) {
		    int tmp = m2;
		    m2 = n2 % m2;
		    n2 = tmp;
	    }
        
        answer[0] = n2; // 최대공약수
        answer[1] = n * m / n2; // 최소공약수 : 두 수를 곱한 값 / 최대공약수
        
        return answer;
    }
}