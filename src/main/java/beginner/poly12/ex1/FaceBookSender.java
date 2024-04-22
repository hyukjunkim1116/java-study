package beginner.poly12.ex1;

public class FaceBookSender implements Sender {
    @Override
    public void sendMessage(String message) {
        System.out.println("페북에 발송합니다:"+message);
    }
}
