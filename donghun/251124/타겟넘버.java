class Solution {
    public int solution(int[] numbers, int target) {
        // 최소 길이일 필요 없고 모든 경우의 수를 구해야함
        // 즉 DFS 알고리즘
        
        // 예시 1의 경우 -1의 위치만 달라지는데 모두 다른 경우로 인정
        
        return dfs(numbers, 0, target, 0);
    }
    
    int dfs(int[] numbers, int index, int target, int result) {
        // 인덱스가 끝까지 도달하면 종료
        if (index == numbers.length) {
            // 연산값이 타겟과 같으면 
            return result == target ? 1 : 0;
        }
        
        int plus = dfs(numbers, index+1, target, result+numbers[index]);
        int minus = dfs(numbers, index+1, target, result-numbers[index]);
        
        return plus+minus;
    }
}