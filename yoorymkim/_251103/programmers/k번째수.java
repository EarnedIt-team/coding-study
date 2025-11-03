package _251103.programmers;

import java.util.*;

public class k번째수 {

    class Solution {
        public int[] solution(int[] array, int[][] commands) {

            int[] answer = new int[commands.length];
            for (int ind = 0; ind < commands.length; ind++) {
                int[] c = commands[ind];
                int i = c[0]; int j = c[1]; int k = c[2];
                int[] cut = new int[j-i+1];

                for (int x = 0; x < j-i+1; x++) {
                    cut[x] = array[x+i-1];
                }
                Arrays.sort(cut);
                answer[ind] = cut[k-1];
            }
            return answer;
        }
    }
}
