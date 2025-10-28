import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        Integer[] arr = new Integer[score.length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = score[i];
        }
        
        // 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        
        int sum = 0;
        int max = 255; 
        int count = 0;
        // 몇개의 사과 상자가 나오는지
        for(int i = 0; i < arr.length; i++) {
            count++;
            if(arr[i] <= max) max = arr[i];
            
            // 현재 해당 사과 상자의 가격 
            if(count == m) {
                sum += arr[i] * m;
                count = 0; // 카운트 초기화
            }
        }
        
        return sum;
    }
} 