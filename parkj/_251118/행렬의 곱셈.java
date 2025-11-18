class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // A 행렬, B 행렬의 곱셈 길이 = A 행렬 행 수(row) X B 행렬 열 수(col)
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        // 행 (row)
        for (int i = 0; i < answer.length; i++) {
            // 열 (col)
            for (int j = 0; j < answer[0].length; j++) {
                int sum = 0; // 곱셈 누적 값
                
                //  행렬 곱셈
                // A와 B의 공통 길이(= A의 열 개수 = B의 행 개수)만큼 진행
                for (int k = 0; k < arr1[0].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                
                answer[i][j] = sum;
            }
        }
        
        return answer;
    }
}
