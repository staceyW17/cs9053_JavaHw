package edu.nyu.cs9053.homework11;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Random;

/**
 * User: blangel
 * Date: 11/23/14
 * Time: 4:31 PM
 */
public class BlockingChatter implements Chatter {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final int BUFFER_SIZE = 1024;
    private final InputStream chatServerInput;
    private final OutputStream chatServerOutput;
    private final InputStream userInput;
    private static final int FILE_LENGHTH = 21691;
    private String[] contents = null;
    private int validLineNumber = 0;

    public BlockingChatter(InputStream chatServerInput, OutputStream chatServerOutput, InputStream userInput) {
        this.chatServerInput = chatServerInput;
        this.chatServerOutput = chatServerOutput;
        this.userInput = userInput;
    }

    @Override public void run() {
        Thread threadForInput = new Thread(new Runnable(){
            public void run(){
                while(true){
                    byte[] buffer = new byte[BUFFER_SIZE];
                    try{
                        int length = userInput.read(buffer);
                        chatServerOutput.write(buffer, 0, length);
                    }catch (IOException e){
                        System.out.printf("Exception - %s%n", e.getMessage());
                    }
                }
            }
        });
        Thread threadForServer = new Thread(new Runnable(){
            public void run(){
                while(true){
                    byte[] buffer = new byte[BUFFER_SIZE];
                    try{
                        chatServerInput.read(buffer);
                        String messageFormServer = new String(buffer);
                        System.out.println(messageFormServer);
                        String easterEggFlag = messageFormServer.substring(19,23);
                        if(easterEggFlag.equals("java")){
                            EasterEgg();
                        }
                    }catch (IOException e){
                        System.out.printf("Exception - %s%n", e.getMessage());
                    }
                }
            }
        });
        threadForServer.start();
        threadForInput.start();
    }

    public void EasterEgg() throws IOException {
        if(contents==null){
            readTxt("src/main/resources/Moby Dick.txt");
        }
        Random random = new Random();
        int randomLineNumber = random.nextInt(validLineNumber);
        byte[] buffer = contents[randomLineNumber].getBytes(UTF8);
        chatServerOutput.write(buffer, 0, buffer.length);
    }

    public void readTxt(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        BufferedReader buffReader = new BufferedReader(reader);
        String line = "";
        contents = new String[FILE_LENGHTH];
        while((line = buffReader.readLine())!=null){
            contents[validLineNumber] = line;
            validLineNumber++;
        }
        buffReader.close();
    }
}
