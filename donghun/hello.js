// donghun의 테스트 코드
console.log("안녕하세요! donghun입니다.");

function greet(name) {
    return `안녕하세요, ${name}님! 코딩 스터디에 오신 것을 환영합니다.`;
}

function calculate(a, b) {
    return a + b;
}

// 테스트 실행
console.log(greet("donghun"));
console.log("계산 결과:", calculate(5, 3));

module.exports = { greet, calculate };
