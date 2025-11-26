package _251126.programmers;

import java.util.*;

public class 캐시 {

    class Solution {
        public int solution(int cacheSize, String[] cities) {
            // LRU : 가장 오랫동안 사용되지 않은 페이지를 제거하는 알고리즘
            // 페이지 교체 알고리즘 : 페이징 기법으로 메모리를 관리하는 운영체제에서, 페이지 부재가 발생 하여 새로운 페이지를 할당하기 위해 현재 할당된 페이지 중 어느 것과 교체할지를 결정하는 방법

        /*
        LRU 알고리즘 예시 : 캐시 크기가 4일 때 1, 2, 3, 1, 4, 5 순서로 페이지를 방문하는 경우

        1. 캐시에 공간이 있으면, 가장 최근에 방문한 페이지가 캐시의 가장 최근 값으로 등록
        2. 캐시에 참조하는 페이지가 있으면 해당 페이지를 캐시의 가장 최근 값으로 등록
            - (예) 캐시에 3, 2, 1 이 등록되어있는 상태에서 1을 방문하는 경우 캐시는 1, 3, 2가 된다.
        3. 캐시에 참조하는 페이지가 없으면 해당 페이지를 캐시의 가장 최근 값으로 등록하고
            && 캐시에 있는 페이지 중 가장 오랫동안 방문하지 않은 페이지를 제거
            - (예) 캐시에 4, 1, 3, 2 가 등록되어있는 상태에서 5를 방문하는 경우,
            가장 오랫동안 방문하지 않은 2를 캐시에서 제거하고 최근 방문 페이지로 5를 등록하여 캐시는 5, 4, 1, 3이 된다.
        */

            if (cacheSize == 0) return cities.length * 5;

            int answer = 0;
            LinkedList<String> cache = new LinkedList<>();
            for (String city : cities) {
                city = city.toUpperCase();

                if (cache.remove(city)) answer += 1; // hit
                else { // miss
                    answer += 5;
                    if (cache.size() >= cacheSize) cache.removeFirst();
                }
                cache.add(city); // 공통 : 최근에 사용한 city 가장 최신
            }

            return answer;
        }
    }

}
