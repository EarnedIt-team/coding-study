class Solution {
	public int[] solution(int[] prices) {
        int n = prices.length;
		int[] answer = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
                answer[i]++; // 넘길때마다 1초씩은 기본적으로 보장
				if (prices[i] > prices[j]) break; // 가격이 떨어지면 중단
			}
		}
        
		return answer;
	}
}
