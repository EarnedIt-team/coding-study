class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        // 0이 될때까지 처리
        while (storey != 0) {
            // 각 자리의 숫자를 가져와서 순차적으로 처리
            int floors = storey % 10;
            // 기준이 되는 층 수가 정확히 5라면
            // 다음 자리로 넘기고, 해당 숫자에서 5 기준을 체크함
            /// ex. storey = 25
            /// floors = 5 이기에, 앞으로 넘겨 30으로 만들고 3 기준으로 처리하게 됨
            if (floors == 5) {
                int next = (storey / 10) % 10;
                answer += 5; // 층 수가 5이기에 다음자릿수로 넘기기위해 +5
                storey = next < 5 ? (storey / 10) : (storey / 10 + 1);
            } else {
                // 기준이 되는 층 수가 5 미만 혹은 초과라면
                // 5미만일때는 "내려가는게" 더 빠르기에 floors만큼 더해주면 됨 (-1, +1 구분이 아닌 행동 카운트)
                // 5초과일때는 "올라가는게" 더 빠르기에 (10 - floors)만큼 더해주면 됨 
                // (ex. 6층 => 10 - 6 = 4번 올라감)
                answer += floors < 5 ? floors : (10 - floors);
                storey = floors < 5 ? (storey / 10) : (storey / 10 + 1);
            }
        }

        return answer;
    }
}
