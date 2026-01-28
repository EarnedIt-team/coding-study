import java.util.*;

class Solution {
    public int[] solution(int n) {
        // 삼각형 영역 채울 2차원배열
        int[][] tri = new int[n][n];
        
        // 하우 (왼위)상
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        
        // 방향(0: 하, 1: 우, 2: 왼위)
        int dir = 0;
        
        // 현재 좌표
        int x = 0; int y = 0;
        
        // 초기위치 초기화
        tri[0][0] = 1;
        
        // 삽입 숫자
        int num = 2; 
        // 채워야 할 총 칸 수 (GPT 도움받음)
        int total = n * (n + 1) / 2; 
        
        while(num <= total) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            // 벽 넘을 때
            if(nx < 0 || ny < 0 || nx >= n || ny >= n || 
               tri[nx][ny] != 0) {
                dir = (dir + 1) % 3; // 방향 전환
                continue;   
            }
            
            // 값 삽입
            tri[nx][ny] = num;
            num++;
            x = nx;
            y = ny;
        }
        
        // 삼각달팽이 사이즈
        int[] answer = new int[total];
        int idx = 0;
        
        // 완성된 배열 1차원으로 풀어주기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(tri[i][j] != 0) {
                    answer[idx] = tri[i][j];
                    idx++;
                }
            }
        }
        
        return answer;
    }
}