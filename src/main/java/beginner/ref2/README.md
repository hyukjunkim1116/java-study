2.기본형과 참조형

2-1 기본형 vs 참조형
```html
변수의 데이터 타입은 사용하는 값을 변수에 직접 넣는 기본형, 객체가 저장된 메모리의 위치를 기리키는 참조값을 넣는 참조형이 있다.
기본형(primitive type): int,long,double..
참조형(reference type): Student, int[] 같이 데이터에 접근하기 위한 참조값을 저장하는 데이터 타입
기본형은 계산 가능 참조형은 계산 불가( .을 넣어서 객체의 기본형 멤버 변수에 접근하면 연산 가능)
```
2-2 변수 대입
```html
대원칙 : 자바는 항상 변수의 값을 복사해서 대입한다.
참조형의 경우 실제 사용하는 객체가 아니라 객체의 위치를 가리키는 참조값만 복사 된다. 데이터로 갈 수 있는 경로가 하나 늘어난 것!
```
2-3 메서드 호출
```html
!!대원칙!! 자바는 항상 변수의 값을 복사해서 대입한다!
메서드를 호출할 때 사용하는 매개변수도 결국 변수이다. 따라서 메서드를 호출할 때 매개변수에 값을 전달하는 것도 값을 복사해서 전달!
따라서 메서드 파라미터에 참조값을 넣으면 내부 값 변경시 실제 값도 변경!
```
2-4 변수와 초기화
```html
멤버 변수: 클래스에 선언
지역 변수: 메서드에 선언. 매개변수도 지역 변수의 한 종류임!
멤버 변수는 자동 초기화 된다. int는 0, bool은 false, 참조형은 null 반면 지역 변수는 수동 초기화 해야함!
```
2-5 GC
```html
아무도 참조하지 않는 인스턴스는 메모리 용량을 차지만 하기 때문에 jvm의 가비지 컬렉션이 메모리에서 제거 한다.
```
2-6 정리
```html
자바는 변수의 값을 항상 복사해서 대입한다.
참조형은 참조값을 복사해서 전달한다.
메서드 호출시 참조형은 메서드 내부에서 매개변수로 전달된 객체의 멤버 변수를 변경하면 호출자의 객체도 변경된다.
```