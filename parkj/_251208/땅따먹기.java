class Solution {
    int solution(int[][] land) {
        // 각 열까지 내려왔을 때의 최대 점수 저장
        int[] numList = new int[4]; // 이전 행의 누적 최대값
        int answer = 0;

        // land의 첫 번째 행을 그대로 num에 넣어줌
        for (int i = 0; i < 4; i++) numList[i] = land[0][i];

        // 두 번째 행부터 끝까지 반복
        for (int i = 1; i < land.length; i++) {
            int[] temp = new int[4]; // 현재 행의 누적 결과를 임시 저장

            for (int j = 0; j < 4; j++) {
                int maxNum = 0;

                // 최대값 찾기
                for (int k = 0; k < 4; k++) {
                    if (k == j) continue; // 같은 열은 제외
                    maxNum = Math.max(maxNum, numList[k]);
                }
                
                // [1,2,3,5] 이후 [5,6,7,8] 기준
                // "5"는 첫번째 열이기에 "1"을 제외한 나머지 값중에 가장 큰 값(5)을 선택
                // [5+5, 0, 0, 0]
                // "6"은 두번째 열이기에 "2"를 제외한 나머지 값중에 가장 큰 값(5)을 선택
                // [5+5, 6+5, 0, 0]
                // .... 이후 완성된 배열 값은 [10, 11, 12, 11]
                temp[j] = land[i][j] + maxNum;
            }

            // 현재 행 결과를 num에 덮어씀
            numList = temp;
        }

        // 마지막 행에서 가장 큰 값 찾기
        for (int v : numList) answer = Math.max(answer, v);

        return answer;
    }
}
