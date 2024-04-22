12.다형성과 설계

12-1 객체 지향 특징
```html
프로그램을 명령어의 목록이 아니라 객체들의 모임으로 파악. 유연하고 변경 용이.
레고 블럭 갈아끼우듯이, 키보드 마우스 갈듯이 컴포넌트를 유연하게 변경하면서 개발하는 방법!
다형성은 역할과 구현으로 세상을 구분.
역할과 구현으로 구분하면 세상이 단순,유연,변경 편리 :: 클라이언트(다른 동료 개발자)는 대상의 역할만 알면 된다. 구현 대상의 내부 구조를 몰라도 된다. 내부 구조가 변경되어도 영향을 받지 않는다. 구현 대상 자체를 변경해도 영향을 받지 않는다.
역할과 구현 분리 : 역할은 인터페이스. 구현은 인터페이스를 구현한 클래스,객체.
객체 설계할때 역할과 구현을 명확히 분리하자
역할을 먼저 부여하고 구현 객체 만들기
```

12-2 다형성의 본질
```html
다형성은 인터페이스를 구현한 객체를 실행 시점에 유연하게 변경할 수 있다.
본질을 이해하려면 협력이라는 객체사이의 관계에서 시작하자
클라이언트를 변경하지 않고 서버의 구현 기능을 유연하게 변경할 수 있다.
실세계를 역할과 구현으로 컨셉화하고 이걸 다형성을 통해 객체 세상으로 가져온다.
따라서 유연하고 변경이 용이하다. 따라서 확장 가능하다.
클라이언트에 영향을 주지 않는 변경이 가능하다.
인터페이스를 안정적으로 잘 설계하는 것이 중요하다.
다형성이 가장 중요!
디자인 패턴 대부분도 다형성 활용
스프링의 제어역전, 의존관계 주입도 다형성 활용
```

12-3 Open-Closed Principle
```html
Open for extension : 새로운 기능이 추가되거나 변경 사항이 생길때, 기존 코드 확장할 수 있어야 한다.
Closed for modification: 기존 코드는 수정되지 않아야 한다.
인터페이스를 통해서 새로운 차량을 자유롭게 추가 가능.
클라이언트는 코드 수정 안해도 됨!
전략 패턴 : 알고리즘을 클라이언트 코드 변경 없이 쉽게 교체 가능! 인터페이스가 전략을 정의하는 인터페이스. 각각 자식이 전략의 구체적인 구현. 그리고 클라이언트 코드 변경 없이 교체!
```