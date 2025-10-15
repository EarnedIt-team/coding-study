// 테스트 케이스 1 실패, (2,3) 성공
// class Solution { 
//     public int solution(int[] players, int m, int k) {
        
//         // 같은 시간대에 이용자가 m명 늘어날 때마다 서버 증설 1개 필요 (m명 미만이면 증설 x)
//         // 어떤 시간대의 이용자가 n*m <= x < (n+1)*m 일때, 최소 n대 서버 가동되어야함
//         // 한번 증설한 서버는 k시간만 운영
        
//         int answer = 0;
        
//         // 증설된 시간 기록
//         int[] arr = new int[24];
        
//         // 시간대별 유저 수 순회
//         for(int i = 0; i < players.length; i++) {
//             int sum = 0;
            
//             // 서버 증설 필요 여부 검증
//             if(players[i] >= m) { // 해당 시간대에 유저수가 m명 이상이라면
                
//                 // 만약 증설된 서버로 충분하다면
//                 if(arr[i] >= players[i]/m) {
//                     continue; // pass
//                 } else { // 증설해야한다면

//                     // 해당 
//                     sum = players[i]/m - arr[i];
//                     answer+=sum;
                    
//                     // 증설된 시간 기록
//                     for(int j=i; j <= i+k; j++) {
//                         if(j+k >= arr.length) break;
                        
//                         arr[j] += sum;
//                     }
//                 }
//             }
//         }
        
//         // 하루동안 모든 게임 이용자가 게임을 하기 위해 서버를 "최소" 몇번 증설해야하는 지 응답
//         return answer;
//     }
// }



// 풀이 2 - 성공
class Solution {
    public int solution(int[] players, int m, int k) {
        
        // 같은 시간대에 이용자가 m명 늘어날 때마다 서버 증설 1개 필요 (m명 미만이면 증설 x)
        // 어떤 시간대의 이용자가 n*m <= x < (n+1)*m 일때, 최소 n대 서버 가동되어야함
        // 한번 증설한 서버는 k시간만 운영
        
        int answer = 0;
        
        // 증설된 시간 기록
        int[] arr = new int[24];
        
        // 시간대별 유저 수 순회
        for(int i = 0; i < players.length; i++) {
            int sum = 0;
            
            // 서버 증설 필요 여부 검증
            if(players[i] >= m) { // 해당 시간대에 유저수가 m명 이상이라면
                
                // 만약 증설된 서버로 충분하다면
                if(arr[i] >= players[i]/m) {
                    continue; // pass
                } else { // 증설해야한다면

                    // 더할 증설 횟수
                    sum = players[i]/m - arr[i];
                    answer+=sum;
                    
                    // 증설된 시간 기록
                    for(int j=i; j < i+k; j++) {
                        if (j >= arr.length) break;
                        
                        arr[j] += sum;
                    }
                }
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        
        
        // 하루동안 모든 게임 이용자가 게임을 하기 위해 서버를 "최소" 몇번 증설해야하는 지 응답
        return answer;
    }
}