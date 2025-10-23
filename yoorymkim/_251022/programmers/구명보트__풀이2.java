package _251022.programmers;
import java.util.*;

public class 구명보트__풀이2 {
    public int solution(int[] people, int limit) {
        // 40 60 70 90 100 110 120 / 제한 140

        // 40 60 / 70 / 90 / 100 / 110 / 120
        // 정렬 후 앞에서부터 치는거랑, 한보트 최대한 맞춰넣기랑 다름 ! 후자택

        // 40 90 / 60 70 / 100 / 110 / 120
        // 40 100 / 60 70 / 90 / 110 / 120
        // 큰 수부터 뒤에서 앞으로 오면서, 앞쪽에 더했을때 제한 이하 생기는 시점 찾기
        // 그때부턴 다 2개로 묶기 가능 ? 그건 아닌거같은데 / 좁혀들어오는게 최고 효율?

        // 40 45 55 70 100 / 105 110 120 121 130 135
        //

        int answer = 0;
        Arrays.sort(people);

        int posInd = people.length; // 가능시작 인덱스 (뒤부터)
        for (int i = people.length-1; i >= 0; i--) {
            if (people[i] + people[0] <= limit) {
                posInd = i;
                break;
            }
        }

        answer = (posInd+1) / 2;
        answer += people.length - 2*answer;

        return answer;
    }
}
