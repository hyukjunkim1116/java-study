11.다형성2

11-1 다형성 활용
```html
여러 클래스 사용시 중복 제거 하려고 하는데, 타입이 서로 달라서 잘 안됨. > 같은 타입을 쓰면 해결
다형적 참조 덕분에 부모 변수는 자식의 인스턴스 참조 가능. 메서드 오버라이딩 덕분에 각 인스턴스의 메서드 호출 가능
새로운 기능이 추가 되었을 때 변하는 부분을 최소화 하는 것이 잘 작성된 코드이다. 코드에서 변하는 부분과 변하지 않는 부분을 명확하게 구분하는 것이 좋다.
```

11-2 추상 클래스
```html
생성할 필요가 없는 클래스를 만들때 쓴다. 이것도 제약을 주기 위함. 좋은 프로그램은? 제약이 있는 프로그램. 협업과 커뮤니케이션을 위해.
메서드,클래스 둘다 사용가능. 추상 메서드가 하나라도 있는 클래스는 추상 클래스로 선언해야 한다.
추상 메서드는 자식 클래스가 반드시 오버라이딩 해야한다.
나머지는 일반 클래스와 동일.
추상 클래스 덕분에 실수로 인스턴스를 생성할 문제를 방지. 실수로 오버라이딩 안하는 문제를 방지.
```

11-3 순수 추상 클래스
```html
추상 클래스의 모든 메서드가 추상 메서드가 되면 순수 추상 클래스라고 한다.
```

11-4 인터페이스
```html
인터페이스 = 순수 추상 클래스. 순추클을 더 편리하게 사용하기 위함
인스턴스 생성 불가 모든 메서드 오버라이딩 다형성을 위해 사용
인터페이스의 모든 메서드는 public, abstract이다.
인터페이스는 다중 구현을 지원한다.
인터페이스에서 모든 멤버 변수는 public, static,final이 모두 포함 되었다고 간주한다.
UML에서 인터페이스 구현은 점선을 사용. implements 키워드로 구현
메모리 구조는 순수 추상 클래스와 같다. 클래스, 추상 클래스, 인터페이스 모두 메모리 구조와 프로그램 코드상 똑같다.
상속은 부모의 기능을 물려받는 것이 목적이라 상속한다고 하고 인터페이스는 모든 메서드를 자식이 모두 오버라이딩 해야 하므로 구현이라고 한다.
```

11-5 인터페이스 사용 이유
```html
모든 메서드를 구현해달라고 제약을 걸 수 있다. 협업과 커뮤니케이션의 관점에서 나의 코드를 다른사람이 올바르게 쓰게 하기 위함
다중구현을 위해 사용한다. 클래스는 부모를 하나만 지정가능 반면 인터페이스는 부모를 여러명 둘 수 있다.
```

11-6 인터페이스의 다중 구현
```html
클래스의 상속을 여러개 받으면 어떤 메서드를 쓸지 애매하다. 하지만 인터페이스는 여러개를 구현해도 된다. 어처피 자식이 구현한 메서드가 실행되니까.
```