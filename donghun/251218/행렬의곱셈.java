import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        /* 
        결과 행렬의 크기는 
        2x3 * 2x2 인 경우 -> 2x3 행렬
        1, 4   3, 3   -> 15, 15
        3, 2   3, 3      15, 15
        4, 1             15, 15
        
        2, 3, 2     5, 4, 3
        4, 2, 4     2, 4, 1
        3, 1, 4     3, 1, 1
        
        (2, 3, 2) * (5, 2, 3) -> 10+6+6 -> 22
        (2, 3, 2) * (4, 4, 1) -> 8+12+2 -> 22
        (2, 3, 2) * (3, 1, 1) -> 6+3+2 -> 11
        
        20+4+12 -> 36 
        ...
        */
        
        int x = arr2[0].length;
        int y = arr1.length;
        
        int[][] answer = new int[y][x];
        
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                // 행렬의 곱 구현
                int[] vector1 = arr1[i];
                int[] vector2 = new int[arr2.length];
                
                // vetor2 는 세로로 접근
                for(int k = 0; k < arr2.length; k++) {
                     vector2[k] = arr2[k][j];
                }
                
                int sum = 0;
                // 곱하기
                for(int mul = 0; mul < arr1[0].length; mul++) {
                    sum += vector1[mul] * vector2[mul];
                }
                
                // 값 삽입
                answer[i][j] = sum;
            }
        }
        
        return answer;
    }
}