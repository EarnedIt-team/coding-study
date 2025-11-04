class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int minX = 0;
        int minY = 0;
        
        for (int[] size : sizes) {
            // 모든 명함을 “가로 ≥ 세로”인 상태로 통일
            // 지금까지 나온 명함들 중에서 가장 긴 값을 계속 저장
            minX = size[0] > size[1] ? Math.max(size[0], minX) : Math.max(size[1], minX);
            minY = size[0] > size[1] ? Math.max(size[1], minY) : Math.max(size[0], minY);
        }
        
        return minX * minY;
    }
}
