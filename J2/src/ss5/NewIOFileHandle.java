/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * @author QQ
 */
public class NewIOFileHandle {
    File source, destination;
    FileInputStream fis;
    FileOutputStream fos;
    
    public void ioPackage(){
        
    }
    
    public void newioPackage() throws Exception{
        source = new File("src/ss5/test1.txt");
        destination = new File("src/ss5/test2.txt");
        fis = new FileInputStream(source);
        fos = new FileOutputStream(destination);
        FileChannel channelSrc = fis.getChannel();
        FileChannel channelDes = fos.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(100); //ByteBuffer.allocate(100); 
        while((channelSrc.read(buf)) != -1){
            buf.flip();
            channelDes.write(buf);
            buf.clear();
        }
        System.out.println("File copy .....");
        channelDes.close();
        channelSrc.close();
        fis.close();
        fos.close();
    }
}
