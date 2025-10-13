# parkj의 테스트 코드

def greet(name):
    """인사말을 출력하는 함수"""
    return f"안녕하세요, {name}님! 코딩 스터디에 오신 것을 환영합니다."

def calculate(a, b):
    """두 수를 더하는 함수"""
    return a + b

def fibonacci(n):
    """피보나치 수열을 계산하는 함수"""
    if n <= 1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)

# 테스트 실행
if __name__ == "__main__":
    print("안녕하세요! parkj입니다.")
    print(greet("parkj"))
    print("계산 결과:", calculate(10, 20))
    print("피보나치 수열 5번째:", fibonacci(5))
