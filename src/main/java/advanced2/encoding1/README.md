1. 문자 인코딩

1-1 컴퓨터와 데이터
```html
개발자가 개발하며 다루는 데이터는 바이너리 데이터와 텍스트 데이터 두가지다.
텍스트 데이터가 어떤 원리를 사용해서 만들어지는지 이해하지 못하면 글자가 깨질때 근본적인 원인을 찾아서 해결하기 어렵다.
컴퓨터의 메모리는 반도체로 만들어져 있는데, 수많은 전구들이 모여있다고 이해하면 된다.
이 전구들은 사실 트랜지스터라고 불리는 아주 작은 전자 스위치이다. 전기가 흐르거나 흐르지 않는 두가지 상태를 가지고 있어서 이를 통해 0과 1이라는 이진수를 표현한다.
이 트랜지스터들이 모여 메모리를 구성한다. RAM이 이런 방식으로 만들어진 메모리의 한 종류이다.
컴퓨터가 정보를 저장하거나 처리할때 이 전구들을 켜고 끄는 방식으로 데이터를 기록하고 읽어들인다.
전구 1개와 같이 2가지만 표현할 수 있는 것을 1비트(bit)라고 한다.
참고로 8bit = 1byte, 컴퓨터는 10진수를 이해하지 못한다. 컴퓨터는 10진수를 2진수로 변경해서 저장한다.
```

1-2 컴퓨터와 문자 인코딩1
```html
문자는 어떻게 저장할까? 문자를 저장하면 컴퓨터는 문자 집합을 통해 해당 문자의 숫자 값을 찾고 2진수로 변환해서 저장한다.
각 회사가 독자적인 문자 집합을 사용한다면 서로 다른 컴퓨터간에 문자가 올바르게 표시되지 않는다. 따라서 ASCII라는 표준 문자 집합이 등장했다.
7비트를 사용하여 128가지 문자를 표현한다.
이후 ISO_8859_1이 등장했다. 서유럽 중심으로 컴퓨터 사용 인구가 늘어나서 서유럽 언어를 지원하는 문자 집합이 필요했다.
한국에도 컴퓨터 사용 인구가 늘면서 한글을 표현할 수 있는 문자 집합이 필요해졌다. 1980년도에 EUC-KR이 등장했다.
1990년도에는 MS가 EUC-KR을 확장하여 MS949를 만들었다.
```

1-3 컴퓨터와 문자 인코딩2
```html
전세계적으로 컴퓨터 사용 인구가 늘어나면서 전세계 문자를 대부분 다 표현할 수 있는 문자 집합이 필요해졌다.
그래서 유니코드가 등장했다. 유니코드는 전세계 문자를 표현하기 위한 문자 집합이다.
UTF-16, UTF-8이 등장했는데, 초반에는 UTF-16이 주로 사용되었다. UTF-16은 2바이트로 문자를 표현한다.
자주 사용하는 다국어는 2byte로 표현하고 나머지는 4byte로 표현했다. ASCII 영문도 2byte를 사용하므로 ASCII와 호환되지 않는 문제가 있었다.
그래서 UTF-8이 등장했다. UTF-8은 가변 길이 문자 인코딩 방식이다. 1byte에서 4byte까지 사용한다.
ASCII 문자는 1바이트로 표현하므로 ASCII와 호환이 가능하다. 따라서 사실상 현대의 표준 인코딩 기술이 되었다.
저장공간을 절약하고 네트워킹에 효율적이다. ASCII 문자로 이루어진 영문 텍스트가 웹의 80%를 차지하는데, 1바이트를 사용한다.
결론 : UTF-8을 사용하자
```

1-4 문자 집합 조회
```html
사용 가능한 문자 집합 조회
Charset.availableCharsets()를 사용하면 이용가능한 모든 문자 집합을 조회할 수 있다.
Charset.forName()을 사용하면 해당 문자 집합을 가져올 수 있다.
StandardCharsets.UTF_8을 사용하면 UTF-8 문자 집합을 상수로 가져올 수 있다.
Charset.defaultCharset()을 사용하면 기본 문자 집합을 가져올 수 있다.
```

1-5 문자 인코딩 예제
```html
```java
public class EncodingMain1 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("== ASCII 영문 처리 ==");
        encoding("A", StandardCharsets.US_ASCII);
        encoding("A", ISO_8859_1);
        encoding("A", EUC_KR);
        encoding("A", MS_949);
        encoding("A", UTF_8);
        encoding("A", UTF_16BE);

        System.out.println("== 한글 지원 ==");
        encoding("가", EUC_KR);
        encoding("가", MS_949); encoding("가", UTF_8); encoding("가", UTF_16BE);
    }

    private static void encoding(String text, Charset charset) {
        byte[] bytes = text.getBytes(charset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte\n",text,charset, Arrays.toString(bytes),bytes.length);
    }
}
```
문자를 컴퓨터가 이해할 수 있는 숫자(byte)로 변경하는 것을 문자 인코딩이라고 한다.
String.getByte(Charset) 메서드를 사용하면 String을 byte배열로 바꿀 수 있다.
문자를 byte로 바꾸려면 문자 집합이 필요하다. Charset.forName()을 사용하면 문자 집합을 가져올 수 있다.
문자 집합을 지정하지 않으면 현재 시스템에서 사용하는 기본 문자 집합을 인코딩에 사용한다.
자바의 byte 타입은 양수와 음수를 모두 표현할 수 있다.
첫번째 비트가 0이면 양수 1이면 음수로 간주된다
결국 자바의 바이트는 256가지 값을 표현하지만 표현 가능한 숫자의 범위는 -128~127이다.
```
```
1-6 문자 인코딩 예제2

```html
```java
public class EncodingMain2 {
    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("== 영문 ASCII 인코딩 ==");
        test("A", US_ASCII, US_ASCII);
        test("A", US_ASCII, ISO_8859_1); // ASCII 확장(LATIN-1)
        test("A", US_ASCII, EUC_KR); // ASCII 포함
        test("A", US_ASCII, MS_949); // ASCII 포함
        test("A", US_ASCII, UTF_8); // ASCII 포함
        test("A", US_ASCII, UTF_16BE); // UTF_16 디코딩 실패
        System.out.println("== 한글 인코딩 - 기본 ==");
        test("가", US_ASCII, US_ASCII); // X
        test("가", ISO_8859_1, ISO_8859_1); // X
        test("가", EUC_KR, EUC_KR);
        test("가", MS_949, MS_949);
        test("가", UTF_8, UTF_8);
        test("가", UTF_16BE, UTF_16BE);
        System.out.println("== 한글 인코딩 - 복잡한 문자 =="); test("뷁", EUC_KR, EUC_KR); // X
        test("뷁", MS_949, MS_949);
        test("뷁", UTF_8, UTF_8);
        test("뷁", UTF_16BE, UTF_16BE);
        System.out.println("== 한글 인코딩 - 디코딩이 다른 경우 =="); test("가", EUC_KR, MS_949);
        test("뷁", MS_949, EUC_KR); // 인코딩 가능, 디코딩 X test("가", EUC_KR, UTF_8); // X
        test("가", MS_949, UTF_8); // X test("가", UTF_8, MS_949); // X
        System.out.println("== 영문 인코딩 - 디코딩이 다른 경우 =="); test("A", EUC_KR, UTF_8);
        test("A", MS_949, UTF_8);
        test("A", UTF_8, MS_949);
        test("A", UTF_8, UTF_16BE); // X
    }

    private static void test(String text, Charset encodingCharset, Charset decodingCharset) {
        byte[] encoded = text.getBytes(encodingCharset);
        String decode = new String(encoded, decodingCharset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte -> [%s] 디코딩 -> %s\n",
                text, encodingCharset, new String(encoded), encoded.length, decodingCharset, decode);
    }
}
```
정리 : ASCII 영문 인코딩은 UTF-16을 제외하고 모두 호환된다. 사실상 표준인 UTF-8을 사용하자
한글이 꺠지는 2가지 이유
- EUC-KR과 UTF-8이 서로 호환되지 않는다. UTF-8로 인코딩한 한글을 EUC-KR(MS949)로 디코딩하거나 그 반대일때 발생한다.
- EUC-KR 또는 UTF-8로 인코딩한 한글을 ISO-8859-1로 디코딩할때. EUC-KR(MS949) 또는 UTF-8로 인코딩한 한글을 한글을 지원하지 않는 ISO-8859-1로 디코딩할때 발생한다.

```





