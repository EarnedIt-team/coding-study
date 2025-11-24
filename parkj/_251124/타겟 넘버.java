class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target); // 깊이 우선 탐색 시작
    }
    
    // ex. [1, 2, 3]
    // 나올 수 있는 모든 경우의 수 : 2^n
    // 1 / -1
    // 1 + 2 / 1 + -2 / -1 + 2 / -1 + -2
    // 1 + 2 + 3 / 1 + 2 + -3 / 1 + -2 + 3 / 1 + -2 + -3 / ...
    // -1 + 2 + 3 / -1 + 2 + -3 / -1 + -2 + 3 / -1 + -2 + -3
    int dfs(int[] numbers, int index, int sum, int target) {
        // 주어진 숫자를 모두 사용하고, 결과값이 타겟 넘버와 동일하다면 1
        if (index == numbers.length) return sum == target ? 1 : 0;

        // 주어진 숫자를 덜 사용했다면, 다음 숫자(+, -)를 합산함
        int plus = dfs(numbers, index + 1, sum + numbers[index], target);
        int minus = dfs(numbers, index + 1, sum - numbers[index], target);

        // 양수일 때 만족하는 경우의 수 + 음수일 때 만족하는 경우의 수 
        return plus + minus;
    }
}
