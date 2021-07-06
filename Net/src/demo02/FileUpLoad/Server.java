package demo02.FileUpLoad;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket accept = serverSocket.accept();

        File file = new File("d:\\upload");
        if (!file.exists()){
            file.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("d:\\upload\\2.jpg");
        InputStream is = accept.getInputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = is.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }

        OutputStream os = accept.getOutputStream();
        os.write("上传成功!".getBytes());

        fos.close();
        accept.close();
        serverSocket.close();
    }
}
