package advanced2.network8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static advanced2.network7.MyLogger.log;
import static advanced2.network8.tcp.SocketCloseUtil.closeAll;

public class SessionV4 implements Runnable {
    private final Socket socket;

    public SessionV4(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream input = null;
        DataOutputStream output = null;
        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

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
        } finally {
            closeAll(socket,input, output);
            log("연결 종료: "+ socket);
        }
    }
}
