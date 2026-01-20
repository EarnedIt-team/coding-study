import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        
        /*
        n : [1, 2, 3]
        k : 5 
        
        경우의 수 6가지를 3으로 나눴을 때 몫은 2
        각각 카드로 시작하는 조합법은 2개씩 
            (1**) *2 (1, 2번째)
            (2**) *2 (3, 4번째)
            (3**) *2 (5, 6번째)
        */
        
        /*
        n : [1, 2, 3, 4]
        k : 13 
        
        경우의 수 24가지를 4으로 나눴을 때 몫은 6
        각각 카드로 시작하는 조합법은 6개씩 
            (1***) *6 (1, 2, 3, 4, 5, 6번째)
            ㄴ 카드 3개 (2, 3, 4) 
            ㄴ (2**) * 2 (1, 2)
            ㄴ (3**) * 2 (3, 4)
            ㄴ (4**) * 2 (5, 6)
            
            
            (2***) *6 (7, 8, 9, 10, 11, 12번째)
            (3***) *6 (13, 14, 15, 16, 17, 18번째)
            ㄴ (3, 1, 2, 4) 13번째 !!
            (4***) *6 (19, 20, 21, 22, 23 ,24번째)
        */
        
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arr.add(i+1);
        }
        
        // n! 구하기
        long f = 1;
        for(int i = 1; i <= n; i++) {
            f*=i;
        }
        
        int[] answer = new int[n];
        int idx = 0;

        k = k - 1; // -> 13 -> 12 
        
        // n번 반복해야함
        while(n > 0) {
            // 전체 경우의 수를 카드 개수로 나누기
            long blockSize = f / n; // ->  {24 / 4 = 6} // {6 / 3 = 2} // {2 / 2 = 1}
            int blockIndex = (int)(k / blockSize); // -> 12 / 6 = 2 [4] 2번째 인덱스
            // System.out.println("blockSize: " + blockSize + ", blockIndex: " + blockIndex);

            // 정답 배열에 삽입
            answer[idx++] = arr.get(blockIndex); // 해당 인덱스 원소 삽입
            arr.remove(blockIndex); // 해당 인덱스 원소 삭제
            
            k = k % blockSize;   // {12 % 6 = 0} // {0 % 2 = 0} // {0 % 1 = 0}
            f = f / n;           // {24 / 4 = 6} // {6 / 3 = 2} // {2 / 2 = 1} 
            n--; // 조합의 한 자리 완성함
        }
        
        return answer;
    }
}