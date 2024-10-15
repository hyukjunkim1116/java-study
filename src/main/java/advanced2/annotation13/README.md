13. 어노테이션

13-1 어노테이션
```html
프로그램 실행중에 읽어서 사용할 수 있는 주석이 어노테이션이다.
```

13-2 생성법
```java
@Retention(RetentionPolicy.RUNTIME)
  public @interface SimpleMapping {
      String value();
  }
```

13-3 생성 규칙
```html
애노테이션 정의 규칙
**데이터 타입**
- 기본 타입 (int, float, boolean 등) String
- `Class` (메타데이터) 또는 인터페이스 enum
- 다른 애노테이션 타입
- 위의 타입들의 배열
- 앞서 설명한 타입 외에는 정의할 수 없다. 쉽게 이야기해서 일반적인 클래스를 사용할 수 없다. 예) `Member` , `User` , `MyLogger`
**default 값**
- 요소에 default 값을 지정할 수 있다.
- 예: `String value() default "기본 값을 적용합니다.";`
**요소 이름**
- 메서드 형태로 정의된다.
- 괄호()를 포함하되 매개변수는 없어야 한다.
**반환 값**
- `void` 를 반환 타입으로 사용할 수 없다.
**예외**
- 예외를 선언할 수 없다.
**특별한 요소 이름**
- `value` 라는 이름의 요소를 하나만 가질 경우, 애노테이션 사용 시 요소 이름을 생략할 수 있다.
```

13-4 메타 어노테이션
```html
@Retention : 어노테이션의 생종 기간을 지정한다
@Target : 어노테이션을 적용할 수 있는 위치를 지정한다
@Documented : 어노테이션 정보를 javadoc으로 작성한 문서에 포함할지 여부를 지정한다
@Inherited : 어노테이션이 자식 클래스에 상속되는지 여부를 지정한다
```

13-5 어노테이션과 상속
```java
 package java.lang.annotation;

public interface Annotation {
    boolean equals(Object obj);

    int hashCode();

    String toString();

    Class<? extends Annotation> annotationType();
}
```
```html
어노테이션은 다른 어노테이션이나 인터페이스를 직접 상속할 수 없다.
오직 java.lang.annotation.Annotation 인터페이스만 상속한다
따라서 어노테이션 사이에서 상속이라는 개념이 존재하지 않는다.
@Inherited는 클래스 상속에서만 적용되고 인터페이스의 구현체에는 적용되지 않는다.
```