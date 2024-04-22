5.enum

5-1 enum이 생긴 이유
```html
타입 안정성 부족 : 단순히 문자열을 입력하는 방식은 오타가 발생하기 쉽고 유효하지 않는 값이 입력될 수 있다.
데이터 일관성 부족 : 다양한 형식으로 문자열 입력 가능
>> String 타입 사용 시 타입 안정성이 부족하다. 값의 제한이 부족하고 컴파일시 오류 감지 불가. 정확환 문자를 전달할 수 없다.
내가 만든 코드의 의도대로 다른 개발자가 사용하지 않을 가능성을 열어둠!
```

5-2 타입 안전 열거형 패턴
```html
public static final로 제한을 걸 수 있다. 하지만 이건 생성자를 만드는걸 막을 수 없다.
이걸 private 생성자로 막는다.
타입 안정성 향상 : 정해진 객체만 사용 가능하기 때문에 잘못된 값을 입력하는 문제를 근본적으로 방지 가능
데이터 일관성 : 정해진 객체만 사용하기 때문에 데이터의 일관성 보장
제한된 인스턴스 생성 : 클래스는 사전에 정의된 몇 개의 인스턴스만 생성
잘못된 값이 할당될 경우 컴파일 시점에 에러냄
public class ClassGrade {
    public static final ClassGrade BASIC = new ClassGrade();
    private ClassGrade() {}
}
이건데 이러면 많은 코드 작성해야함. 따라서 자바에서 enum type 제공
public enum Grade {
    BASIC
}
```

5-3 enum
```html
열거형 enum의 장점
타입 안정성 향상 : 사전에 정의된 상수들로만 구성된다.
간결하고 일관적이다 : 코드가 간결하고 명확하다.
확장적이다 : enum에 새로운 상수를 추가하기만 하면 확장된다.
주요 메서드
.values() 상수 배열 반환
.valueOf(String name) 일치하는 상수 반환
.name() 이름을 문자열로 반환
.ordinal() 상수의 선언 순서를 반환
.toString() 상수의 이름을 문자열로 반환
열거형은 java.lang.Enum을 자동으로 상속 받기 때문에 다른 클래스 상속 받기 불가.
인터페이스 구현 가능
추상 메서드 선언하고 구현 가능
GUEST(1,"손님")
private final int level;
private final String description;
this.level =level;
this.description = description; 이러면 enum 생성자 인수가 2개 되는것임
외부에서 임의 생성 불가
```