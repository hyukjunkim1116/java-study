package advanced2.network8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static advanced2.network7.MyLogger.log;
import static advanced2.network8.tcp.SocketCloseUtil.closeAll;

public class ClientV4 {


    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("Client Start");
        Socket socket = null;
        DataInputStream input = null;
        DataOutputStream output = null;

        try {
            socket = new Socket("localhost", PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            log("Connected to Server: " + socket);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("전송 문자: ");
                String toSend = scanner.nextLine();
                output.writeUTF(toSend);
                log("client -> server: " + toSend);
                if (toSend.equals("exit")) {
                    break;
                }
                String received = input.readUTF();
                log("client <- server: " + received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            closeAll(socket, input, output); log("연결 종료: " + socket);
        }
        input.close();
        output.close();
        socket.close();
    }
}
