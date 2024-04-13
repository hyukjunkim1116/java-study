3. 조건문

3-1 if문
```html
특정 조건에 따라서 다른 코드를 실행하는 것을 조건문이라고 한다.
if문: 조건이 참이면 특정 코드 블록을 실행한다. if (cond) {}
else문: 만족하는 조건이 없을 때 실행한다.
else if: if문이 나열되어 있을 때 불필요한 조건 검사가 계속된다면? 조건을 중복 체크한다면? 코드 효율성이 떨어진다. 그래서 else if 문 사용
서로 독립적인 조건이면 if문을 각각 따로 사용해야한다.
```
3-2 switch문
```html
switch문은 if문을 더 편리하게 사용할 수 있는 기능이다. 단순히 값이 같은지만 비교 가능.
break는 switch문을 빠져나가게 한다.
default는 조건식의 결과값이 모든 case값과 일치하지 않을 때 실행된다.
switch (cond) {
    case a:
        break;
    case b:
    case c:
    case d:
    default:
        //식
}
break가 없으면 계속 실행된다.
if vs switch: switch문은 조건식 안되고 값만 넣어서 체크 할 수 있다. if는 조건식도 가능.
```
3-3 새로운 switch문
```html
int coupon = switch (cond) {
    case 1 -> val;
};
애로우 평션 사용, 데이터 반환 가능
```
3-4 삼항 연산자
```html
참 거짓에 따라 특정 값을 구할 경우 삼항 연산자 혹은 조건 연산자라고 불리는 ?:를 사용한다.
```