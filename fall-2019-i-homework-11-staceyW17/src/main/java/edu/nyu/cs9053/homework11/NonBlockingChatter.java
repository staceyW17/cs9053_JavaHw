package edu.nyu.cs9053.homework11;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * User: blangel
 * Date: 11/23/14
 * Time: 4:32 PM
 */
public class NonBlockingChatter implements Chatter {
    private final static int BUFFER_SIZE = 1024;
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private final SocketChannel chatServerChannel;
    private final ByteBuffer readBuffer = ByteBuffer.allocate(BUFFER_SIZE);
    private final ByteBuffer writeBuffer = ByteBuffer.allocate(BUFFER_SIZE);
    private final Pipe.SourceChannel userInput;


    public NonBlockingChatter(SocketChannel chatServerChannel,
                              Pipe.SourceChannel userInput) throws IOException {
        this.chatServerChannel = chatServerChannel;
        this.userInput = userInput;

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                userInput.read(writeBuffer);
                writeBuffer.flip();
                chatServerChannel.write(writeBuffer);
                writeBuffer.clear();
                int result = chatServerChannel.read(readBuffer);
                if (result > 0) {
                    readBuffer.flip();
                    CharsetDecoder decoder = UTF8.newDecoder();
                    CharBuffer charBuffer = decoder.decode(readBuffer);
                    readBuffer.clear();
                    System.out.printf("%s%n", charBuffer.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}