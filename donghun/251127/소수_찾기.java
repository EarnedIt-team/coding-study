// charAt() 으로 하나씩 접근
        // 배열에 각각 저장
        // 나올 수 있는 모든 숫자 조합을 탐색
        // 숫자 조합 중 소수가 몇개인지 카운트
        
        // [1, 2, 3, 4, 5, 6, 7] 이라면?
        
        //              1           
        //         2           3          4          5          6           7    
        //     3 4 5 6 7  2 4 5 6 7  2 3 5 6 7   2 3 4 6 7  2 3 4 5 7   2 3 4 5 6

        import java.util.*;

        class Solution {
            // 중복을 허용하지 않는 조합 저장용
            Set<Integer> set = new HashSet<>();
            
            public int solution(String numbers) {
                
                int len = numbers.length();
                
                String[] ch_list = new String[len];
                boolean[] visited = new boolean[len];
                
                // 에라토스테네스 체 미리 세팅 7자리
                boolean[] primes = sieveOfEratosthenes(9999999);
                
                // String 배열 세팅
                for(int i = 0; i < len; i++) {
                    ch_list[i] = String.valueOf(numbers.charAt(i));
                }
                
                // dfs 호출
                dfs(ch_list, visited, primes, "");
                
                return set.size();
            }
            
            private void dfs(String[] ch_list, boolean[] visited, boolean[] primes, String str) {
                // 유효성 검사 및 Set에 추가
                if(!str.equals("")) {
                    int num = Integer.parseInt(str);
                     // 소수 판별
                    if(!primes[num]) set.add(num);
                }
                
                // 방문하지 않은 인덱스에 대해 모두 dfs 호출
                for(int i = 0; i < visited.length; i++) {
                    if(!visited[i]) {
                        // 방문 처리
                        visited[i] = true; 
                        // 다음 깊이로 이동
                        dfs(ch_list, visited, primes, str + ch_list[i]);
                        // dfs 완료 후 다시 방문x 처리
                        visited[i] = false;
                    }
                }
            }
            
             // 에라토스테네스의 체 구현
            private boolean[] sieveOfEratosthenes(int n) {
                boolean[] prime = new boolean[n + 1]; // false = 소수, true = 소수 아님
        
                // 0과 1은 소수가 아님
                prime[0] = true;
                prime[1] = true;
        
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (!prime[i]) {
                        for (int j = i * i; j <= n; j += i) {
                            prime[j] = true; // 배수는 소수 아님
                        }
                    }
                }
        
                return prime;
            }
        }