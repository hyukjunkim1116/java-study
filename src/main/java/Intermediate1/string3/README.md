3.String 클래스

3-1 기본
```html
문자를 다루는 타입은 char, String 2가지가 있다.
char은 문자 하나를 다룰 때 사용한다. 여러 문자를 나열하려면 char[]을 사용해야 한다. 이는 매우 불편하다.
따라서 String 클래스를 사용한다.
```

3-2 String
```html
String str1 = "spring";
이는 매우 이상하다. 참조형인데 값이 바로 들어간다. 이건 자바에서 편의상 봐준다.
String 클래스 안에 다양한 기능을 제공한다. 주요 메서드는
length()` : 문자열의 길이를 반환한다.
`charAt(int index)` : 특정 인덱스의 문자를 반환한다.
`substring(int beginIndex, int endIndex)` : 문자열의 부분 문자열을 반환한다.
`indexOf(String str)` : 특정 문자열이 시작되는 인덱스를 반환한다.
`toLowerCase()` , `toUpperCase()` : 문자열을 소문자 또는 대문자로 변환한다. 
`trim()` : 문자열 양 끝의 공백을 제거한다.
`concat(String str)` : 문자열을 더한다.
+ 연산도 가능 원칙적으로는 사용 불가.
```

3-3 String클래스의 비교
```html
== : 동일성
.equals() : 동등성
자바는 문자열 리터럴 사용하는 경우 메모리 효율성과 성능 최적화를 위해 문자열 풀을 사용한다.
따라서 문자열 리터럴을 사용하는 경우 같은 참조값을 가지므로 == 비교에 성공한다.
협업과 커뮤니케이션을 위해 항상 equals()를 사용해서 동등성 비교를 하자.
```

3-4 String은 불변객체
```html
String은 불변 객체이므로 변경할때 새로운 결과를 만들어서 반환한다.
```

3-5 주요 메서드
```html
외우지 말고 필요할때 찾아보자
length()` : 문자열의 길이를 반환한다.
`isEmpty()` : 문자열이 비어 있는지 확인한다. (길이가 0)
`isBlank()` : 문자열이 비어 있는지 확인한다. (길이가 0이거나 공백(Whitespace)만 있는 경우), 자바 11
`charAt(int index)` : 지정된 인덱스에 있는 문자를 반환한다.
equals(Object anObject)` : 두 문자열이 동일한지 비교한다. 
`equalsIgnoreCase(String anotherString)` : 두 문자열을 대소문자 구분 없이 비교한다.
`compareTo(String anotherString)` : 두 문자열을 사전 순으로 비교한다.
`compareToIgnoreCase(String str)` : 두 문자열을 대소문자 구분 없이 사전적으로 비교한다.
`startsWith(String prefix)` : 문자열이 특정 접두사로 시작하는지 확인한다.
`endsWith(String suffix)` : 문자열이 특정 접미사로 끝나는지 확인한다.
contains(CharSequence s)` : 문자열이 특정 문자열을 포함하고 있는지 확인한다.
`indexOf(String ch)` / `indexOf(String ch, int fromIndex)` : 문자열이 처음 등장하는 위치를
반환한다.
`lastIndexOf(String ch)` : 문자열이 마지막으로 등장하는 위치를 반환한다.
substring(int beginIndex)` / `substring(int beginIndex, int endIndex)` : 문자열의 부분
문자열을 반환한다.
`concat(String str)` : 문자열의 끝에 다른 문자열을 붙인다.
`replace(CharSequence target, CharSequence replacement)` : 특정 문자열을 새 문자열로 대체
한다.
`replaceAll(String regex, String replacement)` : 문자열에서 정규 표현식과 일치하는 부분을 새
문자열로 대체한다.
`replaceFirst(String regex, String replacement)` : 문자열에서 정규 표현식과 일치하는 첫 번째
부분을 새 문자열로 대체한다.
`toLowerCase()` / `toUpperCase()` : 문자열을 소문자나 대문자로 변환한다. 
`trim()` : 문자열 양쪽 끝의 공백을 제거한다. 단순 `Whitespace` 만 제거할 수 있다.
`strip()` : `Whitespace` 와 유니코드 공백을 포함해서 제거한다. 자바 11
문자열 분할 및 조합**
`split(String regex)` : 문자열을 정규 표현식을 기준으로 분할한다.
`join(CharSequence delimiter, CharSequence... elements)` : 주어진 구분자로 여러 문자열을
결합한다.
**기타 유틸리티**
`valueOf(Object obj)` : 다양한 타입을 문자열로 변환한다.
`toCharArray():` 문자열을 문자 배열로 변환한다.
`format(String format, Object... args)` : 형식 문자열과 인자를 사용하여 새로운 문자열을 생성한
다.
`matches(String regex)` : 문자열이 주어진 정규 표현식과 일치하는지 확인한다.
```
3-6 StringBuilder - 가변 String
```html
불변 String 클래스의 단점은 문자를 더하거나 변경할 때 계속 새로운 객체를 생성해야 한다는 점이다.
문자를 자주 더하거나 변경해야 한다면 새로운 객체생성과 gc가 많이 발생한다. 이는 컴퓨터의 자원을 더 많이 사용하게 된다.
이걸 해결하는 방법은 StringBuilder를 사용하는 것이다.
이는 가변이며 사이드 이펙트에 주의해서 사용하자
사용 예시
StringBuilder` 객체를 생성한다.
`append()` 메서드를 사용해 여러 문자열을 추가한다.
`insert()` 메서드로 특정 위치에 문자열을 삽입한다.
`delete` () 메서드로 특정 범위의 문자열을 삭제한다. 
`reverse()` 메서드로 문자열을 뒤집는다.
마지막으로 `toString` 메소드를 사용해 `StringBuilder` 의 결과를 기반으로 `String` 을 생성해서 반환한다.
```

3-7 String 최적화
```html
자바는 문자열 리터럴을 컴파일시에 최적화 시켜준다.(예를 들어 결합 연산을 컴파일때 실행함)
문자열 변수의 경우는 컴파일 시점에는 알 수 없다. 이런경우 StringBuilder를 사용해서 최적화를 수행한다.
반복문에서 문자열 합치는 경우 연산이 매우 많으면 최적화가 어렵다 이때 StringBuilder를 사용한다.(반복 횟수만큼 객체를 생성해야 함)
따라서 StringBuilder를 직접 사용하는 것이 더 좋은 경우
1. 반복문에서 반복해서 문자 연결
2. 조건문을 통해 동적으로 문자열 조합
3. 복잡한 문자열의 특정 부분 변경
4. 매우 긴 대용량 문자열 다루기
```

3-8 메서드 체이닝
```html
메서드가 자기 자신을 반환하면 .(dot)을 계속 적어서 체이닝할 수 있다.
메서드 체이닝 기법은 코드를 간결하고 읽기 쉽게 만들어준다.
만든 사람이 수고로우면 쓰는 사람이 편하고, 만드는 사람이 편하면 쓰는 사람이 수고롭다는 말이있다.
메서드 체이닝은 구현하는 사람은 힘들지만 사용하는 사람은 편해진다.
고맙다 라이브러리와 오픈소스
```