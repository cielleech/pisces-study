package org.pisces.netty.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.MessageBuf;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyTests {

    public static void main(String[] args) throws IOException {
        NettyTests tests = new NettyTests();
        
        tests.mockSocket();
    }

    private void mockNetty() throws IOException {
        RandomAccessFile file = new RandomAccessFile("E:\\cielleech\\Documents\\家庭组.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(2056);
        int bytesRead = channel.read(buffer);
        buffer.flip();

        CharBuffer charBuffer = Charset.forName("utf-8").decode(buffer);
        System.out.println(charBuffer.toString());

        // ServerBootstrap bootstrap = new ServerBootstrap(new
        // NioServerSocketChannel

    }

    private void mockSocket() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        Socket socket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());

        String request = null;
        String response = null;

        while ((request = in.readLine()) != null) {
            if ("Done".equals(request)) {
                break;
            }
        }

        response = request + "Done";

        out.println(response);
    }
}
