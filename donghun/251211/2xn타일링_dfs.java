class Solution {
    int answer = 0;
    public int solution(int n) {
        // 가로 길이가 짝수이면 가로 타일로만 완성되는 경우 1개, 세로로만 세웠을 때 경우 1개
        
        // 가로 길이가 홀수이면 가로 타일로만 완성되는 경우 x
        
        // 입출력 예시 1 (n = 4)
        // (2,2), (1,1,1,1), (1,1,2), (2,1,1), (1,2,1)
        
        // 입출력 예시 2 (n = 3)
        // (1, 2), (1,1,1), (2, 1)
        
        // -> 1과 2로 n을 만들수 있는 모든 조합 개수를 리턴하면 될것같음.
        // dfs? 
        dfs(n, 0, 0);
        
        return answer;
    }
    
    private void dfs(int n, int depth, int add_count) {
        // 아직 해당 깊이까지 가지 못했다면
        if(depth < n) {
            dfs(n, depth+1, 1);
            dfs(n, depth+2, 2);
        } else if(depth == n) {
            answer++;
        } 
    }
}