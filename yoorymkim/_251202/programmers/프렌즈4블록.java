package _251202.programmers;

import java.util.*;

public class 프렌즈4블록 {

    class Solution {
        public int solution(int m, int n, String[] board) {
            // 2×2 형태만(3x3 안됨) / 겹치는 부분 있을 수 있음 -> 1회에 한꺼번에 지워짐
            // (떨어지는 속도는 무시..겠지?ㅎ) / 지워질 것 없을 때까지 ?회 반복
            // n : 각 String의 길이 / m : board[].length (판 위로도 아이템이 있다는 조건 아님 !!)

            // Stack이라기엔 중간을 빼먹음 => 동적배열종류 or String / 위에서 아래로 : 세로선 기준.

            String[] sero = new String[n];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) { //세로기준 String으로 변환
                for (int j = 0; j < m; j++) {
                    sb.append(board[j].charAt(i));
                }
                sero[i] = sb.toString();
                sb.setLength(0);
            }

            int answer = 0;
            while(true) { // n회차 반복
                // 터뜨릴 애들 위치 저장
                boolean[][] mustPop = new boolean[n][m];
                for (int i = 0; i < n-1; i++) {
                    for (int j = 0; j < m-1; j++) {
                        if (sero[i].charAt(j) != '.' &&
                                sero[i].charAt(j) == sero[i+1].charAt(j) &&
                                sero[i].charAt(j+1) == sero[i+1].charAt(j+1) &&
                                sero[i].charAt(j) == sero[i+1].charAt(j+1)) {
                            mustPop[i][j] = true; mustPop[i+1][j] = true;
                            mustPop[i][j+1] = true; mustPop[i+1][j+1] = true;
                        }
                    }
                }

                // 터뜨리기
                int popNum = 0;
                for (int i = 0; i < n; i++) {
                    StringBuilder sb2 = new StringBuilder(sero[i]);

                    for (int j = m - 1; j >= 0; j--) {
                        if (mustPop[i][j] == true) {sb2.deleteCharAt(j); popNum++;}
                    }

                    // 위쪽 빈공간 있으면 .로 채우기
                    while (sb2.length() < m) sb2.insert(0, '.');

                    sero[i] = sb2.toString();
                }

                if(popNum == 0) break;
                else answer += popNum;
            }

            return answer;
        }
    }
}
