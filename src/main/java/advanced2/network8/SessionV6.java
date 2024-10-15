package advanced2.network8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static advanced2.network7.MyLogger.log;
import static advanced2.network8.tcp.SocketCloseUtil.closeAll;
import static jdk.internal.net.http.common.Utils.close;

public class SessionV6 implements Runnable {
    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;
    private final SessionManagerV6 sessionManager;
    private boolean closed = false;

    public SessionV6(Socket socket,SessionManagerV6 sessionManager) throws IOException {
        this.socket = socket;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.sessionManager = sessionManager;
        this.sessionManager.add(this);
    }

    @Override
    public void run() {

        try {
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
            sessionManager.remove(this);
            close();
        }
    }
    public synchronized void close() {
        if (closed) return;
        closeAll(socket, input, output);
        closed = true;
        log("연결 종료: " + socket);

    }
}
