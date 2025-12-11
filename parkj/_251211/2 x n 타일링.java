class Solution {
    public int solution(int n) {
        // 최대로 배치가 가능한 수 : 타일을 세로로 전부 배치하는 n
        int[] placeList = new int[n + 1];

        // 가로의 길이가 1일 때, 경우의 수 : 1 (세로 1개 배치)
        placeList[1] = 1;
        
        // 가로의 길이가 2일 때, 경우의 수 : 2 (가로 1개 / 세로 2개 배치)
        placeList[2] = 2;
        
        /// 가로의 길이가 3일 때, 경우의 수 : 길이가 1일 때 경우의 수 + 길이가 2일 때 경우의 수
        // 세로로 배치 된 경우, n-1 길이만큼 채우면 되고
        // 가로로 배치 된 경우, n-2 길이만큼 채우면 되기에
        // placeList[3] = placeList[1] + placeList[2]

        // 피보나치 수
        // 가로 길이가 i 일때, 경우의 수 : 바로 앞 두 항의 합
        // 경우의 수가 많아지기에 1,000,000,007를 나눈 나머지 값으로 리턴되게 설정
        for (int i = 3; i <= n; i++) {
            placeList[i] = (placeList[i - 1] + placeList[i - 2]) % 1_000_000_007;
        }

        return placeList[n];
    }
}
