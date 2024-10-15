package advanced2.network7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static advanced2.network7.MyLogger.log;

public class ClientV3 {


    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("Client Start");
        Socket socket = new Socket("localhost", PORT);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        log("Connected to Server: " +socket);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("전송 문자: ");
            String toSend = scanner.nextLine();

            output.writeUTF(toSend);
            log("client -> server: " + toSend);
            if (toSend.equals("exit")) {
                break;
            }
            // 서버로부터 문자 받기
            String received = input.readUTF();
            log("client <- server: " + received);
        }


        input.close();
        output.close();
        socket.close();

    }
}
