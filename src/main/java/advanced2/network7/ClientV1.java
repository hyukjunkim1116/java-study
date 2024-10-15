package advanced2.network7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static advanced2.network7.MyLogger.*;

public class ClientV1 {


    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("Client Start");
        Socket socket = new Socket("localhost", PORT);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        log("Connected to Server: " +socket);

        String toSend = "Hello";
        output.writeUTF(toSend);
        log("Sent: " + toSend);
        String recieved = input.readUTF();
        log("Received: " + recieved);

        input.close();
        output.close();
        socket.close();

    }
}
