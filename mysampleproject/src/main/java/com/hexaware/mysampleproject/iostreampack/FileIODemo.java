/**
 * IO -> Input Output
 * 
 * Stream -> sequence of data. 
 *  -> data flow
 * 
 * 1. Standard Output -> System.out
 * 2. Standard Input -> Keyboard
 * 3. Standard Error
 * 
 * IO Streams are in the java.io package
 * 
 * OutputStream -> abstract class
 * 1. write(int)
 *    write(byte[])
 * 2. flush()
 * 3. close()
 * 
 * Input Stream
 * 1. read()
 * 2. close()
 * 3. available()
 * 
 * FileOutputStream class -> writes into files
 *  -> IOException
 * 
 * 
 * 
 * 
 */

package com.hexaware.mysampleproject.iostreampack;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIODemo {
    public void writeToFile() {
        String data = "This is a line to write into a file";

        String path = "E:/trainings/hexaware/Dec2020 - Feb2021/projects/java codes/outputfile.txt";

        try {
            FileOutputStream fos = new FileOutputStream(path);
            byte[] bArray = data.getBytes();
            fos.write(bArray);
            fos.close();
        } catch(Exception e) {
            System.out.println("Could not find the file");
        }
    }

    public void readFromFile() {
        String path = "E:/trainings/hexaware/Dec2020 - Feb2021/projects/java codes/outputfile.txt";

        try {
            FileInputStream fis = new FileInputStream(path);
            int i = fis.read();

            while(i != -1) {
                System.out.print((char)i);
                i = fis.read();
            }
            fis.close();
        } catch(Exception e) {
            System.out.println("Could not find the file");
        }
    }
}
