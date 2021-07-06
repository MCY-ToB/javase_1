package demo03.FileUpLoad;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        while (true){
            Socket accept = serverSocket.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        File file = new File("d:\\upload");
                        if (!file.exists()){
                            file.mkdirs();
                        }

                        String fileName = "itcast" + System.currentTimeMillis() + new Random().nextInt(10000) + ".jpg";
                        FileOutputStream fos = new FileOutputStream(file + "\\" + fileName);
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
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();



        }
//        serverSocket.close();


    }
}
