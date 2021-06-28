/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class normalUser extends user {

    protected static boolean normalCheck(String name, String pwd) {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/normalUser.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String Temp[] = line.split(",");
                String userName = Temp[0];
                String password = Temp[1];
                if (userName.equals(name) && password.equals(pwd)) {
                    return true;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(adminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(adminUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    protected static boolean adduser(String name, String pwd) {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/normalUser.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String Temp[] = line.split(",");
                String userName = Temp[0];
                String password = Temp[1];
                if (userName.equals(name)) {
                System.out.println(userName +" "+password);
                    return false;
                }
            }

            FileWriter fw = new FileWriter(f, true);

            if (f.length() != 0) {
                fw.write("\n");
            }
            fw.write(name + "," + pwd);
            fw.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(adminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(adminUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

}
