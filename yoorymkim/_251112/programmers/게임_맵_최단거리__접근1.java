package _251112.programmers;

public class 게임_맵_최단거리__접근1 {
    class Solution {
        public int solution(int[][] maps) {
            // 0,0 -> n-1,m-1 / 1칸씩 이동하며 넓이우선탐색
            // 최소거리는 갔던 길 되돌아가지 않음

            int answer = 0;

            int i = 0; int n = maps.length;
            int j = 0; int m = maps[0].length;
            while (i < n-1 && j < m-1) {
                maps[i][j] = 0; //밟고있는 길 다시 안감

                if (i-1 >= 0 && maps[i-1][j]==1) { // 상
                    i--;
                }
                else if (i+1 < n && maps[i+1][j]==1) { // 하
                    i++;
                }
                else if (j-1 >= 0 && maps[i][j-1]==1) { // 좌
                    j--;
                }
                else if (j+1 >= m && maps[i][j+1]==1) { // 우
                    j++;
                }
                else {
                    return -1;
                }

                answer++;
            }

            return answer;
        }

        private void gogo(int[][] maps) {

        }
    }
}
