2.불변 객체

2-1 기본형과 참조형의 공유
```html
기본형 : 하나의 값을 여러 변수에서 절대로 공유하지 않는다
참조형 : 하나의 객체를 참조값을 통해 여러 변수에서 공유할 수 있다.
자바는 항상 값을 복사해서 대입한다
참조형 사용시 공유 참조가 발생하고 사이드 이펙트가 터질 수 있다.
처음부터 서로 다른 인스턴스를 참조하면 된다.
하지만 하나의 객체를 여러 변수가 공유하지 않도록 강제로 막을 수 있는 방법은 없다.
```

2-2 불변 객체
```html
위의 문제의 원인은 공유된 객체의 값을 변경한 것이다.
객체의 상태가 변하지 않는 객체를 불변 객체라고 한다.
불변 클래스를 만들면 문제가 해결된다. 필드 값을 변경할 수 없게 설계하면 된다.
불변이라는 제약을 사용해서 사이드 이펙트를 막을 수 있다.
```

2-3 불변 객체의 값 변경
```html
가변 객체는 set메서드를 통해 값을 직접 변경하지만, 불변 객체는 새로운 인스턴스를 만들어 반환한다.
따라서 불변 객체에서 변경과 관련된 메서드들은 꼭 반환 값을 받아야 한다!
불변 객체에서 값을 변경할때 with으로 시작하게 네이밍한다.
```

2-4 정리
```html
String 클래스가 불변 객체이고 수 많은 클래스가 불변이기 때문에 불변 객체가 필요한 이융하 원리를 제대로 이해해야 한다.
```