import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NIOServer {
    static List<SocketChannel> socketChannelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.accept().bind(new InetSocketAddress(9000));
        serverSocket.configureBlocking(false);// 配置nio
        System.out.println("server start successful");

        while(true) {
            SocketChannel socketChannel = serverSocket.accept();
            if (socketChannel != null) {
                System.out.println("connect successful!");
                socketChannelList.add(socketChannel);
            }

            Iterator<SocketChannel> iterator = socketChannelList.iterator();
            while(iterator.hasNext()){
                SocketChannel sc = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                int len = sc.read(byteBuffer);
                if(len>0){
                    System.out.println("接收到客户端的数据" + new String(byteBuffer.array()));
                }else if(len==-1){
                    socketChannelList.remove(sc);
                }

            }
        }

    }


}
