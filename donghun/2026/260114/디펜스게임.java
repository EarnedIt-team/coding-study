import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        // 배열에서 큰 수를 빼는게 묘수는 아님
        // [2, 3, 3, 1, 4, 4, 5] -> (4,5,4) 빼면 2라운드 컷남
        
        // for문을 통해 n에서 원소를 하나씩 빼면서 임의의 List에 해당 원소를 추가
        // enemy < n이 되는 시점에서 List에서 가장 큰 원소를 빼면서 k--; 
        // k == 0이 되는 시점이 정답
        
        // maxHeap으로 최댓값 탐색 O(Log(N)) 
        PriorityQueue<Integer> maxHeap = 
            new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            maxHeap.add(enemy[i]);
            
            // 체력을 깎았을 때 음수라면
            if(n < 0) {
                if (k > 0) {
                    // List에 있는 원소 중 가장 큰 수를 무적권을 소모하여 pass
                    int max = maxHeap.poll(); // 가장 앞의 원소 제거 
                    n+=max;
                    k--;    
                } else {
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}