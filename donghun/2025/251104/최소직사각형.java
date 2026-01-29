import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        // 가로 < 세로 라면 일단 가로로 눕히기
        // 가로 > 세로 인 상태로 배열 완성해놓고, 거기서 만들 수 있는 지갑 크기 구하기
        
        // 가로 > 세로인 상태로 만드는 for문
        for(int i = 0; i < sizes.length; i++) {
            int width = sizes[i][0];
            int height = sizes[i][1];

            // 덮어씌우기
            if(width < height) {
                sizes[i][0] = height;
                sizes[i][1] = width;
            }
        }
        
        int width_max = 0;
        int height_max = 0;
        // 가로, 세로 값 정렬되어있는 값 순회하며 최대값 갱신
        for(int i = 0; i < sizes.length; i++) {
            int width = sizes[i][0];
            int height = sizes[i][1];
            
            width_max = Math.max(width, width_max);
            height_max = Math.max(height, height_max);

            // System.out.println("(width, height) = " + 
            //                    "(" + width + "," + height + ")" );
        }
        
        int answer = width_max * height_max;
        return answer;
    }
}