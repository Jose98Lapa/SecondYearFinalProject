package eapli.base.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SplitInfo {
    private final static int SIZE_LIMIT = 250;
    public static <V> byte[][] splitObjectIntoByteArray (V object){
        try{
            byte[] bytes;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(object);
            outputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();
            outputStream.close();
            byteArrayOutputStream.close();
            byte[][] returnInfo = new byte[bytes.length/SIZE_LIMIT+1][SIZE_LIMIT];
            int bytesCount = 0;
            for (int i=0;i< returnInfo.length;i++){
                for (int j=0;j<SIZE_LIMIT;j++){
                    returnInfo[i][j] = bytes[bytesCount];
                    bytesCount++;
                }
            }
            return returnInfo;

        }catch (IOException e){
            e.printStackTrace();
        }
        return new byte[0][0];




    }

}
