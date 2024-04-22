6.접근 제어자

6-1 접근 제어자
```html
접근 제어자가 필요한 이유 : 협업시 다른 개발자의 나의 코드를 활용할때 내 의도대로 동작하기 위해.
클래스의 변수들을 오픈하면 다른 개발자는 내가 필요에 의해서 오픈한줄 알고 쓴다. 그럼 오류 발생
```
6-2 접근 제어자 종류
```html
private: 모든 외부 호출 막는다
default(pakage-private): 같은 패키지안에서 호출 허용
protected: 같은 패키지안에서 호출 허용 + 상속 관계의 호출 허용
public: 모든 외부 호출 허용
private이 가장 많이 차단. public이 가장 많이 허용
프라이빗 > 디폴트(명시하지 않으면 디폴트 적용) > 프로텍티드 > 퍼블릭
```

6-3 접근 제어자 - 클래스 레벨
```html
클래스 레벨 접근 제어자는 public, default만 사용 가능
public 클래스는 파일명과 이름이 같아야 한다
하나의 자바 파일에 public 클래스는 하나만 등장해야 함
default 클래스는 무한정 만들기 가능
```

6-4 캡슐화
```html
캡슐화를 통해 데이터의 직접적인 변경을 방지하거나 제한 가능.
캡슐화는 한마디로 속성과 기능을 하나로 묶고 외부에 필요한 기능만 노출하고 나머지는 내부로 숨기는것
캡슐화에서 필수로 숨겨야 하는 것은 속성이다.
내부에서만 사용하는 기능을 숨겨라. 필요한 기능만 노출하자
접근 제어자를 통해 캡슐화를 안전하게 완성할 수 있다. 협업과 커뮤니케이션을 할때 내 코드를 다른 개발자가 접근제어자를 보고 이해한다느 사실을 명심하자.
```