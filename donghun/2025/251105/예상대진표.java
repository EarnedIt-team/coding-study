class Solution
{
    public int solution(int n, int a, int b)
    {
        // 2라면 1이랑 붙고.. 3이면 4랑 붙고.. 
        
        // (라운드 1)
        // 이기면 4번 참가자는 2*2(다음라운드 순서) = 4, 2번
        // 이기면 7번 참가자는 2*4(다음라운드 순서) = 8, 4번
        
        // (라운드 2)
        // => 2번은 이기면 2*1(다음라운드 순서) = 2, 1번
        // => 4번은 이기면 2*2(다음라운드 순서) = 4, 2번
        
        // (라운드 3)
        // => 1번은 이기면 2*1(다음라운드 순서) = 2, 1번(숫자 일치)
        // => 2번은 이기면 2*1(다음라운드 순서) = 2, 1번(숫자 일치)
        // 이때 라운드를 반환하도록 코드 구현
        
                            
        int round = 1;
        int a_rank = a;
        int b_rank = b;
        
        // 라운드 진행
        while(true) {
            // 해당 라운드에서 이겼을 때 다음 라운드에서 몇번인지 도출
            
            // a 참가자의 다음 랭크 도출
            if(a_rank % 2 == 1) {
                a_rank = (a_rank+1) / 2; 
            } else {
                a_rank = a_rank / 2;
            }
            
            // b 참가자의 다음 랭크 도출
            if(b_rank % 2 == 1) { 
                b_rank = (b_rank+1) / 2; 
            } else {
                b_rank = b_rank / 2;
            }
            
            if(a_rank == b_rank) break; 
            round++;
        }

        return round;
    }
}