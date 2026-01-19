import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        int answer = 0;
        
        // 이동 간선 저장 Set
        Set<String> set = new HashSet<>();
        
        // 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // 좌표평면계를 어떻게 구현할 것인가? (10 x 10)
        // (5,5) 를 시작지점으로 움직이기
        int[][] 좌표평면 = new int[11][11];
        
        // 현재 시작 좌표
        int cx = 5, cy = 5;
        
        for(int i = 0; i < dirs.length(); i++) {
            int dir = setDirection(dirs.charAt(i)); // 방향 선택
            
            // 다음 위치 이동
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];
            
            // 벽을 만났다면
            if(nx < 0 || ny < 0 || nx > 10 || ny > 10) continue;
            
            String path1 = cx + " " + cy + " " + nx + " " + ny; // 정방향
            String path2 = nx + " " + ny + " " + cx + " " + cy; // 역방향
            
            // 아직 방문하지 않은 간선이라면
            if(!set.contains(path1) || !set.contains(path2)) {
                // 방문처리
                set.add(path1);
                set.add(path2);    
                
                answer++; 
            }
            cx = nx;
            cy = ny;
        }
        
        return answer;
    }
    
    private int setDirection(char c) {
        switch (c) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 3;
            default:
                throw new IllegalArgumentException("Invalid direction: " + c);
        }
    }
}