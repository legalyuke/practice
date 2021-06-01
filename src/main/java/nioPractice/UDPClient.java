package nioPractice;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @author liyuke
 * @date 2021-05-18 21:18
 */
public class UDPClient {
    public void send() throws IOException {
        //获取DatagramChannel数据报通道
        try (DatagramChannel dChannel = DatagramChannel.open()) {
            //设置为⾮阻塞
            dChannel.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocate(1000);
            Scanner scanner = new Scanner(System.in);
            System.out.println("UDP客户端启动成功");
            System.out.println("请输⼊发送内容:");
            while (scanner.hasNext()) {
                String next = scanner.next();
                buffer.put((new Date() + " >>" + next).getBytes());
                buffer.flip();
                //通过DatagramChannel数据报通道发送数据
                dChannel.send(buffer, new InetSocketAddress("127.0.0.1", 8283));
                buffer.clear();
            }
            //操作四：关闭DatagramChannel数据报通道
        }
    }

    public static void main(String[] args) throws IOException {
        new UDPClient().send();
    }
}
