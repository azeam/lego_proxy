package com.azeam;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class ProxyInitializer extends ChannelInitializer<SocketChannel> {
    private final String[] server1 = { "127.0.0.1", "8080" };
    private final String[] server2 = { "127.0.0.1", "8081" };
    private boolean firstSelected = true;

    @Override
    public void initChannel(SocketChannel channel) {
        firstSelected = !firstSelected;
        String ip = getServer(channel)[0];
        int port = Integer.parseInt(getServer(channel)[1]);
        channel.pipeline().addLast(
                new ProxyFrontendHandler(ip, port));
    }

    private String[] getServer(SocketChannel channel) {
        return firstSelected ? server1 : server2;
    }
}
