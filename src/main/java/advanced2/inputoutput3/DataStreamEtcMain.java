package advanced2.inputoutput3;

import java.io.*;

public class DataStreamEtcMain {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(TextConst.FILE_NAME);
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF("회원A");
        dos.writeInt(20);
        dos.writeDouble(10.5);
        dos.writeBoolean(true);
        dos.close();
        FileInputStream fis = new FileInputStream(TextConst.FILE_NAME);
        DataInputStream dis = new DataInputStream(fis);
        System.out.println(dis.readUTF());
        System.out.println(dis.readInt());
        System.out.println(dis.readDouble());
        System.out.println(dis.readBoolean());
        dis.close();
    }
}
