
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adliih
 */
public class FileIO {
    public String[] loadDatabaseSetup() throws IOException{
        String[] dbSetup = new String[3];
        File file = new File("Database Setup.txt");
        if (!file.exists()){
            resetDatabaseSetup();
        }
        int i = 0;
        try    (FileInputStream fis = new FileInputStream(file);
                DataInputStream dis = new DataInputStream(fis);){
            String y = dis.readLine();
            while (y != null) {
                dbSetup[i++] = y.substring(y.lastIndexOf("=") + 1).replace(" ", "");
                y = dis.readLine();
            }
        }
        return dbSetup;
    }
    
    public void resetDatabaseSetup() throws FileNotFoundException, IOException{
        File file = new File("Database Setup.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        try     (FileOutputStream fos = new FileOutputStream(file);
                DataOutputStream dos = new DataOutputStream(fos);){
            dos.writeBytes("Database URL = \n");
            dos.writeBytes("Database Username = \n");
            dos.writeBytes("Database Password = \n");
        }
    }
    
}
