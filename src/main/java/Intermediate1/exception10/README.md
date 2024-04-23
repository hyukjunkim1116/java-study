10.예외 처리2

10-1 예외 처리 도입
```html
public class NetworkClientExceptionV2 extends Exception {
    private String errorCode;
    public NetworkClientExceptionV2(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
}
}
오류가 발생했을 때 예외를 던진다. 덕분에 메서드가 정상 처리되면 성공이고 예외가 발생하면 실패를 확인 할 수 있다.
```

10-2 정상, 예외 흐름 분리
```html
try catch를 통해 정상 흐름은 try로 들어가고 예외는 catch로 분리한다. 하지만 예외 발생시에도 실행해야 하는 코드가 있다면?
finally를 사용한다. 그러면 catch 블록이 실행되기 전에 finally 코드가 실행된다. 정상흐름일때도 try가 끝나고 finally가 실행된다.
```

10-3 예외 계층
```html
예외를 계층화하고 다양하게 만들면 더 세밀한 동작들을 깔끔하게 처리할 수 있다. 그리고 특정 분류의 공통 예외들도 한번에 catch로 잡아서 처리할 수 있다.
```

10-4 실무에서 예외 처리
```html
대부분의 예외는 잡아도 해결할 수 없다. 그리고 프로그램이 복잡해지면서 체크 예외가 너무 많아졌다.
이런 경우 모든 체크예외를 명시적으로 처리해야 하므로 지옥이 펼쳐진다. 이는 상당히 번거로운 일이 된다.
지저분한 코드가 만들어진다. throws Exception을 하면 모든 체크 예외를 다 밖으로 던지는데 일부 중요한 체크 예외를 체크할 수 없다.
따라서 언체크 예외를 사용하는데, 필요한 예외만 잡으면 되고 나머지는 한곳에서 공통으로 처리한다.
이러면 본인 스스로 코드에 더 집중할 수 있다.

try {
    networkService.sendMessage(input);
    } catch (Exception e) { 
    // 모든 예외를 잡아서 처리 
    exceptionHandler(e);
}
//공통 예외 처리
private static void exceptionHandler(Exception e) {
    //공통 처리
    System.out.println("사용자 메시지: 죄송합니다. 알 수 없는 문제가 발생했습니다."); System.out.println("==개발자용 디버깅 메시지=="); e.printStackTrace(System.out); // 스택 트레이스 출력 //e.printStackTrace(); // System.err에 스택 트레이스 출력
    //필요하면 예외 별로 별도의 추가 처리 가능
    if (e instanceof SendExceptionV4 sendEx) {
    System.out.println("[전송 오류] 전송 데이터: " + sendEx.getSendData()); }}
```

10-5 try-with-resources
```html
어플에서 외부 자원을 사용하는 경우 반드시 외부 자원을 해제하자
따라서 finally 구문을 반드시 사용해야 한다.
AutoCloseable 인터페이스를 구현해야 한다.
public interface AutoCloseable {
void close() throws Exception;
}
cloas() 메서드는 try가 끝나면 자동으로 호출된다.
try (NetworkClientV5 client = new NetworkClientV5(address)) {
    client.initError(data);
    client.connect();
    client.send(data);
    } catch (Exception e) {
    System.out.println("[예외 확인]: " + e.getMessage()); 
    throw e;
}
이런 식으루
리소스 누수 방지, 코드 간결성 및 가독성 향상, 스코프 범위 한정, 빠른 자원 해제의 장점이 있다.
```

10-6 정리
```html
처음 자바를 설계할 당시 체크 예외가 더 나은 선택이라 생각했다. 하지만 복구할 수 없는 예외가 너무 많아졌다. 특히 라이브러리를 사용할때.
이럴때마다 throws에 예외를 계속 써야했다. 이런 문제점 때문에 최근 라이브러리들을 대부분 런타임 예외를 기본으로 제공한다.
런타임 예외도 필요하면 잡을 수 있기 때문에 필요한 경우에는 잡아서 처리하고 그렇지 않으면 자연스럽게 던지도록 둔다. 그리고 처리할 수 없는 예외는
예외를 공통으로 처리하는 부분을 만들어서 해결하자.
```