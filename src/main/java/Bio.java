import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Bio {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        Socket clientSocket = serverSocket.accept();
        System.out.println("获得链接");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    handler(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        ).start();

    }
    private static void handler(Socket socket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备read");
        int read = socket.getInputStream().read(bytes);

        if(read!=1){
            System.out.println("接收到客户端的数据" + new String(bytes,0,read));
        }
    }
}
