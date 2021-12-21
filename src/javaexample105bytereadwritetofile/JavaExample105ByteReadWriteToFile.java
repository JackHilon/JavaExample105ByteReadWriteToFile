
package javaexample105bytereadwritetofile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class JavaExample105ByteReadWriteToFile {

    
    public static void main(String[] args) {
        
        File folder = MyHelper.CreateWorkingFolder("myWorkingFolder");
        
        MyHelper.FolderCheck(folder);
        
        File fil = MyHelper.CreateWorkingFile(folder, "myData.dat");
        
        MyHelper.FileCheck(fil);
        
        try{
            FileOutputStream fos = new FileOutputStream(fil);
            
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            
            bos.write(8);
            
            for (char i = 'E'; i < 'W'; i++) {
                bos.write(i);
            }
            
            bos.close();
            fos.close();
            
            //==================================================================
            System.out.println("---------------------------------------------");
            
            FileInputStream fis = new FileInputStream(fil);
            
            BufferedInputStream bis = new BufferedInputStream(fis);
            
            byte[] byteArray = new byte[1000];
            
            int amount = bis.read(byteArray);
            
            for (int i = 0; i < amount; i++) {
                System.out.println(i + " " +(char) byteArray[i]);
            }
            
            // close
            bis.close();
            fis.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
     
        
        
        
    }
}
