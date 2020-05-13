package com.netty.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;


/**
 * 序号${}
 *
 * @author menggy
 * @date 2020/5/13 17:16
 */
public class TestConnect {
    public static void main(String[] args) {
        Channel channel = new NioSocketChannel();
        //回调,可以注册listener
        final ChannelFuture future = channel.connect(new InetSocketAddress("localhost", 25));
        future.addListener(
                new ChannelFutureListener() {
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if(channelFuture.isSuccess()){
                            ByteBuf buf= Unpooled.copiedBuffer("Hello", Charset.defaultCharset());
                            ChannelFuture wf=future.channel().writeAndFlush(buf);
                        }else {
                            Throwable cause=future.cause();
                            cause.printStackTrace();
                        }
                    }
                }
        )

    }
}
