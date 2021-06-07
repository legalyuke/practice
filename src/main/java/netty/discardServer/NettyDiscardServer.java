package netty.discardServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author liyuke
 * @date 2021-06-02 23:35
 */

public class NettyDiscardServer {

    private final int serverPort;
    ServerBootstrap b = new ServerBootstrap();

    public NettyDiscardServer(int port) {
        this.serverPort = port;
    }

    public void runServer() {
        //创建反应器线程组
        EventLoopGroup bossLoopGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerLoopGroup = new NioEventLoopGroup();
        try {
            //1 设置反应器线程组
            b.group(bossLoopGroup, workerLoopGroup);
            //2 设置nio类型的通道
            b.channel(NioServerSocketChannel.class);
            //3 设置监听端⼝
            b.localAddress(serverPort);
            //4 设置通道的参数
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            //5 装配⼦通道流⽔线
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                //有连接到达时会创建⼀个通道
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    // 流⽔线管理⼦通道中的Handler处理器
                    // 向⼦通道流⽔线添加⼀个handler处理器
                    ch.pipeline().addLast(new NettyDiscardHandler());
                }
            });
            // 6 开始绑定服务器
            // 通过调⽤sync同步⽅法阻塞直到绑定成功
            ChannelFuture channelFuture = b.bind().sync();
            System.out.println("服务器启动成功，监听端⼝:" + channelFuture.channel().localAddress());
//            Logger.info(" 服务器启动成功，监听端⼝: " + channelFuture.channel().localAddress());
            // 7 等待通道关闭的异步任务结束
            // 服务监听通道会⼀直等待通道关闭的异步任务结束
            ChannelFuture closeFuture = channelFuture.channel().closeFuture();
            closeFuture.sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 8关闭EventLoopGroup，
            // 释放掉所有资源包括创建的线程
            workerLoopGroup.shutdownGracefully();
            bossLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 9520;
        new NettyDiscardServer(port).runServer();
    }
}
