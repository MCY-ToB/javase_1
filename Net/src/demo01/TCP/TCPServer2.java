package demo01.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket accept = serverSocket.accept();

        byte[] bytes = new byte[1024];
        InputStream inputStream = accept.getInputStream();
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));

        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("服务器2收到!".getBytes());

        accept.close();
        serverSocket.close();

    }
}
