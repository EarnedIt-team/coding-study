import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        // 인덱스 번호와 근태 점수, 동료 평가 점수 담는 리스트
        List<int[]> list = new ArrayList<>();
        
        int answer = -1;
        
        // 완호의 인센티브 여부 판단
        if(!완호인센티브여부판단(scores)) return -1;
        
        // 일단 인덱스 번호에 맞게 삽입
        for(int i = 0; i < scores.length; i++) {
            list.add(new int[]{i, scores[i][0], scores[i][1]});
        }
        
        // 다른 사원들의 인센티브 여부 판단에 따라 List추가
        // 원하는 상태로 정렬
        Collections.sort(list, (a, b) -> {
            // 근태 점수가 같다면 동료 평가 점수로 오름차순
            if(a[1] == b[1]) return a[2]-b[2]; 
            return b[1] - a[1];
        });
        
        // 인센티브 못받는 직원 판별
       int maxPeer = 0;
        // 인덱스 번호와 합산 점수 담는 리스트
        List<int[]> result = new ArrayList<>();
        
        // 사원 하나씩 꺼냄
        for(int i = 0; i < list.size(); i++) {
            int[] emp = list.get(i);
            
            if(emp[2] < maxPeer) {
                continue;
            } else {
                maxPeer = emp[2];
                result.add(new int[]{emp[0], emp[1]+emp[2]});
            }
        }
        
        // 내림차순 정렬
        sort(result);
        
        int rank = 1; // 실제 카운트
        int prev = result.get(0)[1];
        
        // 인덱스 0인 완호의 순위 탐색
        for(int i = 0; i < result.size(); i++) {
            if(result.get(i)[1] < prev) {
                rank = i + 1;
                prev = result.get(i)[1];
            }
            // index 0 (완호)를 만나면 정답 리턴
            if(result.get(i)[0] == 0) return rank;            
        }
        
        return answer;
    }
    
    // List를 내림차순 정렬하는 메서드
    void sort(List<int[]> list) {
        list.sort((a, b) -> {
            int sumA = a[1];
            int sumB = b[1];
            return sumB - sumA;
        });
    }
    
    void printList(List<int[]> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.println("index: " + list.get(i)[0] + ", [" 
                               + list.get(i)[1] + ", " + list.get(i)[2] + "]");
        }
    } 
    
    boolean 완호인센티브여부판단(int[][] scores) {
        // 완호의 인센티브 여부 판단
        int wanho_score1 = scores[0][0];
        int wanho_score2 = scores[0][1];
        
        for(int i = 0; i < scores.length; i++) {
            // 임의의 사원보다 두 점수가 모두 낮은 경우가 있다면
            if(wanho_score1 < scores[i][0] && wanho_score2 < scores[i][1]) {
                return false;
            }
        }
        return true;
    }
}