class Solution {
    public int[] solution(int brown, int yellow) {
        // 카펫의 가로, 세로 길이를 배열로 리턴해라.
        int[] answer = new int[2];
        
        // 더하는 이유는, 크기를 아는게 아닌 "격자의 개수"만 기억하기 때문
        int totalSize = brown + yellow; // 전체 넓이
        
        // 카펫의 가로, 세로 길이는 최소 3 이상이 되어야 한다.
        // 만약 3이하의 값이 된다면, 노란색이 배치될 수 없는 경우가 발생하기 때문
        for (int i = 3; i <= totalSize; i++) {
            /// 전체 넓이 : 가로 * 세로
            int col = i; // 세로
            int row = totalSize / col; // 가로
            
            // 만약 계산된 가로길이가 3 이하라면 다음으로 넘김
            if (row < 3) {
                continue;
            } else {
                // 가로 길이는 세로 길이와 같거나, 세로 길이보다 길다는 제한사항
                if (row >= col) {
                    // 노란색 타일이 들어가는 최소 조건 : (가로 - 2) * (세로 - 2)
                    // 넓이는 곧 개수의 합을 의미합니다.
                    if ((row - 2) * (col - 2) == yellow) {
                        answer[0] = row; // 가로
                        answer[1] = col; // 세로
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}
