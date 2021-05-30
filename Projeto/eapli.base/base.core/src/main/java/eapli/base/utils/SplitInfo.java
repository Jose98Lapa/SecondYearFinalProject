package eapli.base.utils;

import java.io.*;
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
                    if (bytesCount==bytes.length)
                        break;
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

    public static Object joinSplitInfo(byte [][]info){
        byte[] arr = new byte[info.length*info[0].length];
        int byteCount = 0;
        for (int i=0;i<info.length;i++){
            for (int j=0;j<info[i].length;j++){
                arr[byteCount] = info[i][j];
                byteCount++;
            }
        }
        try{
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arr);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            byteArrayInputStream.close();
            objectInputStream.close();
            return object;

        }catch (IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;

    }

    public static byte[] serializeObject(Object obj) throws IOException {
        ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bytesOut);
        oos.writeObject(obj);
        oos.flush();
        byte[] bytes = bytesOut.toByteArray();
        bytesOut.close();
        oos.close();
        return bytes;
    }

}
