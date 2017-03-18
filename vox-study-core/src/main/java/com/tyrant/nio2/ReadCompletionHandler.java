package org.pisces.nio2;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by cielleech on 2016/4/9.
 */
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsynchronousSocketChannel channel;

    public ReadCompletionHandler(AsynchronousSocketChannel channel) {
        if (this.channel == null)
            this.channel = channel;
    }

    public void completed(Integer result, ByteBuffer attachment) {
        // TODO Auto-generated method stub
        
    }

    public void failed(Throwable exc, ByteBuffer attachment) {
        // TODO Auto-generated method stub
        
    }

    
}
