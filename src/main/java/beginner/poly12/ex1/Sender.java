package beginner.poly12.ex1;

public interface Sender {
//    인터페이스의 모든 메서드는 public, abstract이다.
//    인터페이스는 다중 구현을 지원한다.
//    인터페이스에서 모든 멤버 변수는 public, static,final이 모두 포함 되었다고 간주한다.
    void sendMessage(String message);
}
