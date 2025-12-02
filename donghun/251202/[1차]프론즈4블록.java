import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        
        // 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)
        
        // m*n 배열은 만들어야할듯 [CHECK]
        // 1번째 위치 기준으로 x~x+1, y~y-1 지점까지가 2x2 블록 (이 조건을 한번의 전체 탐색 후 한번에 처리) [CHECK]
        // 해당 좌표들을 어딘가에 저장해두었다가 한꺼번에 제거 및 개수 카운팅 [CHECK]
        
        // 제거 후 여백부분에는 위의 블록들이 떨어져 채워져야함
        
        int answer = 0;
        
        // 높이 m, 폭 n, 배치 정보 board
        char[][] arr = new char[m][n];
           
        // 중복 저장 방지 
        Set<String> set = new HashSet<>();
        
        // 2차원 배열 세팅
        for(int i = 0; i < m; i++) { 
            for (int j = 0; j < n; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }
        
        // ------------------------------------------------------------------------ while
        while(true) {
            // (y는 m-2), (x는 n-2)까지 2x2 블록이 있는지 확인 후 어딘가 저장
            for(int i = 0; i < m-1; i++) {
                for(int j = 0; j < n-1; j++) {

                    char c = arr[i][j]; // 기준 문자

                    // 2x2 되는지, 공백이면 안됨
                    if(c != ' ' && arr[i][j+1] == c && arr[i+1][j] == c && arr[i+1][j+1] == c) {
                        set.add(i + "," + j);
                        set.add(i + "," + (j+1));
                        set.add((i+1) + "," + j);
                        set.add((i+1) + "," + (j+1));
                    }
                }
            }

            // 확인 완료
            // for (String s : set) {
            //     System.out.println(s);
            // }
            
            // set 사이즈가 0이라면 종료
            if(set.isEmpty()) break;

            // set에 저장된 값들 전부 소거
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    // set에 저장된 i, j와 일치하면 제거 후 카운팅 +1
                    if(set.contains(i+","+j)) {
                        arr[i][j] = ' ';
                        answer++;
                    } 
                }
            }
            
            // 소거 후, 위의 블록들 내려와야함
            for (int col = 0; col < n; col++) {
                int emptyRow = m - 1;

                for (int row = m - 1; row >= 0; row--) {
                    if (arr[row][col] != ' ') {
                        char block = arr[row][col];
                        arr[row][col] = ' ';
                        arr[emptyRow][col] = block;
                        emptyRow--;
                    }
                }
            }
            // set 초기화
            set.clear();
        }
        
        
        
        return answer;
    }
}