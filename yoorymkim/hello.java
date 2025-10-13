// yoorymkim의 테스트 코드
public class HelloWorld {
    
    public static void main(String[] args) {
        System.out.println("안녕하세요! yoorymkim입니다.");
        
        String greeting = greet("yoorymkim");
        System.out.println(greeting);
        
        int result = calculate(15, 25);
        System.out.println("계산 결과: " + result);
        
        // 배열 예제
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("배열 합계: " + sumArray(numbers));
    }
    
    public static String greet(String name) {
        return "안녕하세요, " + name + "님! 코딩 스터디에 오신 것을 환영합니다.";
    }
    
    public static int calculate(int a, int b) {
        return a + b;
    }
    
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
