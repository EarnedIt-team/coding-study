import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        List<Integer> arr = new ArrayList<>();
        
        for(int sc : score) {
            arr.add(sc);
        }
        
        // 내림차순 정렬
        Collections.sort(arr, Collections.reverseOrder());
        
        int sum = 0;
        int max = 255; 
        int count = 0;
        // 몇개의 사과 상자가 나오는지
        for(int i = 0; i < arr.size(); i++) {
            count++;
            if(arr.get(i) <= max) max = arr.get(i);
            
            // 현재 해당 사과 상자의 가격 
            if(count == m) {
                sum += arr.get(i) * m;
                count = 0; // 카운트 초기화
            }
        }
        
        return sum;
    }
} 