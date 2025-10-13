// 풀이 1 - 실패 (일부 통과)
// import java.util.*;

// class Solution {
//     public String solution(String s) {
//         StringBuilder sb = new StringBuilder();
        
//         // 문자열을 공백으로 쪼개고 첫 문자를 대문자로 변경해야함
        
//         String[] split = s.split(" ");
        
//         for(int i = 0; i < split.length; i++) {
//             // 문장 조각
//             char[] ch = split[i].toCharArray();
            
//             // 쪼갠 문자열의 첫 글자가 알파벳일 때
//             if('a' < ch[0] && ch[0] < 'z') {
//                 char c = Character.toUpperCase(ch[0]);
//                 ch[0] = c;
//             }
//             for(int j = 0; j < ch.length; j++) {
//                 if(j != 0 && ('A' < ch[j] && ch[j] < 'Z')) {
//                     ch[j] = Character.toLowerCase(ch[j]);
//                 }
                
//                 sb.append(ch[j]);
//             }
            
//             if(i != split.length - 1) {
//                 sb.append(" ");    
//             }
//         }
        
//         String answer = sb.toString();
        
//         return answer;
//     }
// }


// 풀이 2 - 성공
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        // 문자열을 공백으로 쪼개고 첫 문자를 대문자로 변경해야함
        
        String[] split = s.split(" ", -1); // 연속된 공백까지 쪼갬
        
        for(int i = 0; i < split.length; i++) {
            // 문장 조각
            char[] ch = split[i].toCharArray();
           
            for(int j = 0; j < ch.length; j++) {
                 // 쪼갠 문자열의 첫 글자가 알파벳일 때
                if(j == 0 && ('a' <= ch[0] && ch[0] <= 'z')) {
                    ch[j] = Character.toUpperCase(ch[j]);
                } else if(j > 0 && ('A' <= ch[j] && ch[j] <= 'Z')) {
                    ch[j] = Character.toLowerCase(ch[j]);
                }
                
                sb.append(ch[j]);
            }
            
            if(i != split.length - 1) sb.append(" ");    
        
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}