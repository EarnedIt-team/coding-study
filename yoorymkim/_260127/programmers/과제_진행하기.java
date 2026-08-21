package _260127.programmers;

import java.util.*;
import java.io.*;

public class 과제_진행하기 {
// 시작시각 분단위로 환산하기 -> 함수 따로파자
// PriorityQueue : 작은 값이 우선순위가 높으므로 적합! 시각 기준으로 가보자
// 멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작합니다. -> 후입선출 : stack

    class Solution {
        public String[] solution(String[][] plans) {
            PriorityQueue<Homework> pq = new PriorityQueue<>(
                    (a, b) -> Integer.compare(a.start, b.start) // start값 기준으로 우선순위
            );

            for (String[] plan : plans) { // 우선순위큐 초기화
                pq.offer(new Homework(plan[0], TimeToMin(plan[1]), Integer.parseInt(plan[2])));
            }

            /// 큐 돌리기 시작 ~~~~

            String[] answer = new String[plans.length]; int i = 0; // 정답배열 & 접근용idx
            Stack<Homework> st = new Stack<>(); // 멈춰둔 과제 누적하는 stack

            Homework prev = pq.poll(); // 과제 첫 시작 !
            int now = prev.start; // 현재 시각

            // 큐에 새 과제들 남은 동안
            while (!pq.isEmpty()) {
                Homework next = pq.poll();
                if (next.start >= now + prev.playtime) { // 현재과제 한번에 끝내기 가능 경우
                    now += prev.playtime;
                    answer[i] = prev.name; i++; // 현재과제 끝, 저장

                    // 과제 끝내고 시간남음 && 기존과제 있음
                    int remainTime = next.start - now;
                    while ((remainTime != 0) && !st.isEmpty()) {
                        Homework paused = st.pop();
                        if (paused.playtime <= remainTime) { // 멈춰둔 과제를 끝내기 가능 경우
                            remainTime -= paused.playtime;
                            now += paused.playtime;
                            answer[i] = paused.name; i++;
                        }
                        else { // 멈춰둔 과제 끝내기 불가 경우
                            paused.playtime -= remainTime;
                            st.push(paused);
                            now += remainTime;
                            remainTime = 0;
                            break;
                        }
                    }
                }
                else { // 지금 과제 끝내기 전에 멈추고 새과제 시작해야함
                    prev.playtime -= next.start - now;
                    st.push(prev);
                    now = next.start;
                }
                now = next.start;
                prev = next;
            }

            // 마지막 과제 완료
            answer[i] = prev.name; i++;

            while(!st.isEmpty()) { // 마지막 과제 이후 스택에 남은 과제 소진
                Homework next = st.pop();
                answer[i] = next.name; i++;
            }

            return answer;
        }

        private int TimeToMin(String s) {
            StringTokenizer st = new StringTokenizer(s, ":");
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());
            return hour*60 + min;
        }
    }

    class Homework {
        String name;
        int start;
        int playtime;

        Homework(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
}
