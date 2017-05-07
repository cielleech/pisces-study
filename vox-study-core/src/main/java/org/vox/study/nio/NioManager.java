package org.vox.study.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by cielleech on 2017/3/18.
 */
public class NioManager {
    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("e:\\14558.dump");

        FileChannel channel = stream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        channel.read(buffer);

        buffer.flip();
        while(buffer.hasRemaining()) {
            byte b = buffer.get();
            System.out.println(b);
        }

        channel.close();
        stream.close();
    }
}
