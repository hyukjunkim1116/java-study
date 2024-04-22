7.자바 메모리 구조와 static

7-1 자바 메모리 구조
```html
메서드 영역 : 클래스 정보 보관. 공통 데이터 관리. 클래스 정보, 스태틱 변수, 공통 리터럴 상수 보관
스택 영역 : 실제 프로그램 실행되는 영역. 메서드 실행시 하나씩 쌓임
힙 영역 : 객체가 생성되는 영역. 배열도 여기서 생성됨. 참조되지 않는 객체는 GC에 의해 제거
```

7-2 스택과 큐
```html
스택 : 후입 선출
큐 : 선입 선출
```

7-3 static
```html
static은 멤버 변수와 메서드에 사용된다.
특정 클래스에서 공용으로 함꼐 사용하기 위해 사용된다. 클래스이름.(dot)으로 접근
```

7-4 용어 정리
```html
인스턴스 변수 : static이 붙지 않은 멤버 변수. 이 변수는 인스턴스를 생성해야 사용할 수 있다. 인스턴스 생성시 새로 만들어진다.
클래스 변수 : static이 붙은 멤버 변수. 클래스변수,정적변수,static 변수등으로 불린다. 클래스 자체에 소속되어 있음
```

7-5 변수와 생명주기
```html
지역 변수 : 지역 변수는 스택 프레임 안에 보관된다. 메서드가 종료되면 지역변수도 함꼐 제거된다.
인스턴스 변수 : 인스턴스 변수는 힙 영역을 사용한다. gc전까지 생존
클래스 변수 : static 영역 안에 보관되는 변수. jvm이 종료될때 까지 생존한다.
```

7-6 정적 변수 접근
```html
인스턴스를 통한 접근은 오해를 불러 일으킨다. 따라서 클래스를 통해서 접근하자.
```

7-7 static 메서드
```html
단순 기능을 제공하고 인스턴스가 필요하지 않을때 사용.
메서드 앞에 static이 붙으면 정적 메서드 또는 클래스 메서드라고 한다.
정적 메서드는 정적 메서드나 정적 변수만 사용 가능. 모든 곳에서 static 호출 가능
인스턴스 메서드 : static이 붙지 않은 멤버 메서드
클래스 메서드 : static이 붙은 멤버 메서드
유틸리티성 메서드에 자주 사용된다.
마찬가지로 인스턴스를 통한 접근 말고 클래스를 통한 접근이 더 명확하다
main()메서드는 정적 메서드. 프로그램 실행시 main이 static이기 때문에 객체 생성 없이도 작동했다.
```