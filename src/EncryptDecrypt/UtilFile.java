package encryptdecrypt;

import java.io.*;
import java.net.*;

public class UtilFile{
    
    public byte[] read(String aInputFileName){
        File file = new File(aInputFileName);
        byte[] result = new byte[(int)file.length()];
        try {
            InputStream input = null;
            try {
                int totalBytesRead = 0;
                input = new BufferedInputStream(new FileInputStream(file));
                while(totalBytesRead < result.length){
                    int bytesRemaining = result.length - totalBytesRead;
                    //input.read() returns -1, 0, or more :
                    int bytesRead = input.read(result, totalBytesRead, bytesRemaining); 
                    if (bytesRead > 0){
                        totalBytesRead = totalBytesRead + bytesRead;
                    }
                }
            }
            finally {
                input.close();
            }
        }
        catch (FileNotFoundException ex) {
        }
        catch (IOException ex) {
        }
        return result;
    }


    public void write(byte[] aInput, String aOutputFileName){
        try {
            OutputStream output = null;
            try {
                output = new BufferedOutputStream(new FileOutputStream(aOutputFileName));
                output.write(aInput);
            }
            finally {
                output.close();
            }
        }
        catch(FileNotFoundException ex){
        }
        catch(IOException ex){
        }
    }  
}
