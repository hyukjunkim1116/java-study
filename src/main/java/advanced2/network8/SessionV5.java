package advanced2.network8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static advanced2.network7.MyLogger.log;
import static advanced2.network8.tcp.SocketCloseUtil.closeAll;

public class SessionV5 implements Runnable {
    private final Socket socket;

    public SessionV5(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try(DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

            while (true) {
                String received = input.readUTF();
                if (received.equals("exit")) {
                    break;
                }
                String toSend = received + " World!";
                output.writeUTF(toSend);
                log("client <- server: " + toSend);
            }

        } catch (IOException e) {
            log(e);
        }
        log("연결 종료: " + socket + " isClosed: " + socket.isClosed());
    }
}
