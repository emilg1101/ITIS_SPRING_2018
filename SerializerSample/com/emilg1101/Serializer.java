package com.emilg1101;

import java.io.*;

/**
 * SerializerSample
 * Created by Emil Gafiyatullin (Git:emilg1101)
 * on 01.03.18
 */

public class Serializer {

    public static <T> void serialize(T object) {
        try {
            FileOutputStream fos = new FileOutputStream(object.getClass().getName()+".out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static <T> T deserialize(T object) {
        try {
            FileInputStream fis = new FileInputStream(object.getClass().getName()+".out");
            ObjectInputStream oin = new ObjectInputStream(fis);
            return (T) oin.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return object;
        }
    }
}
