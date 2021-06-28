/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatabase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.omg.CORBA.portable.InputStream;

/**
 *
 * @author Mazharul Islam
 */
public class test {

    public static void main(String[] args) throws MalformedURLException, IOException {
        File f = new File("src/adminUser.txt");
        System.out.println(f.getAbsoluteFile().toString());
    }
}
