// import java.util.*;

// class Solution {
//     public int solution(int n, int m, int[] section) {
        
//         // m : 구역 개수 n, 롤러의 길이 m, 칠해야하는 구역 section
//         // section은 오름차순 정렬되어있음
        
//         // 8, 4, [2, 3, 6]
        
//         int[] array = new int[n+1];
//         int count = 0;
        
//         int j = 0;
        
//         // n까지 모두 순회
//         for(int i = 1; i <= n; i++) {
//             // 칠해야하는 곳은 0 처리
//             if(j < section.length && i == section[j]) {
//                 array[i] = 0;
//                 j++;
//             } else {
//                 array[i] = 1;    
//             }
//         }
        
        
//         // n까지 모두 순회
//         for(int i = 1; i <= n; i++) {
//             // 칠해져있지 않다면
//             if(array[i] == 0) {
//                 for(int k = i; k < i+m; k++) {
//                     if(k > n) break; // k가 배열의 끝을 넘지 않도록
//                     array[k] = 1;
//                 }
//                 count++;
//             } else {
//                 continue;
//             }
//         }
        
//         return count;
//     }
// }

// 풀이 2 - 인덱스 점프
import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        
        // m : 구역 개수 n, 롤러의 길이 m, 칠해야하는 구역 section
        // section은 오름차순 정렬되어있음
        
        // 8, 4, [2, 3, 6]
        
        int[] array = new int[n+1];
        int count = 0;
        
        int j = 0;
        
        // n까지 모두 순회
        for(int i = 1; i <= n; i++) {
            // 칠해야하는 곳은 0 처리
            if(j < section.length && i == section[j]) {
                array[i] = 0;
                j++;
            } else {
                array[i] = 1;    
            }
        }
        
        // n까지 모두 순회
        for(int i = 1; i <= n; i++) {
            // 칠해져있지 않다면
            if(array[i] == 0) {
                for(int k = i; k < i+m; k++) {
                    if(k > n) break; // k가 배열의 끝을 넘지 않도록
                    array[k] = 1;
                }
                i = i + m - 1; // 인덱스 점프
                count++;
            } else {
                continue;
            }
        }
        
        return count;
    }
}