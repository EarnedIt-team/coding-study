import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        // 블록을 반복적으로 제거하고 더 이상 작업을 수행하지 못하면, 사라진 블록의 수 계산
        // m = 문자열의 개수 (row)
        // n = 문자열 길이 (col)
        int answer = 0;

        // 문자열 → char 배열 변환
        char[][] block = new char[m][n];
        for (int i = 0; i < m; i++) {
            block[i] = board[i].toCharArray();
        }

        // 반복 제거
        while (true) {

            boolean[][] erase = new boolean[m][n];
            boolean isfound = false;

            // 2×2 블록 탐색
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {

                    char c = block[i][j]; // 기준점
                    if (c == '*') continue; // 이미 지워진 곳은 제외

                    if (c == block[i][j+1] &&
                        c == block[i+1][j] &&
                        c == block[i+1][j+1]) {

                        isfound = true; // 한 개라도 제거 할 블록이 있는가?
                        erase[i][j] = true;
                        erase[i][j+1] = true;
                        erase[i+1][j] = true;
                        erase[i+1][j+1] = true;
                    }
                }
            }

            // 더 이상 지울 게 없으면 종료
            if (!isfound) break;

            // 블록 제거
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (erase[i][j]) {
                        block[i][j] = '*'; // 제거 된 영역을 *로 변경
                        answer++; // 점수 획득
                    }
                }
            }

            // 중력 적용
            for (int j = 0; j < n; j++) {
                int empty = m - 1;
                
                for (int i = m - 1; i >= 0; i--) {
                    if (block[i][j] != '*') {
                        char temp = block[i][j];
                        block[i][j] = '*';
                        block[empty][j] = temp;
                        empty--;
                    }
                }
            }
        }

        return answer;
    }
}
