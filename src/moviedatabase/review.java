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

/**
 *
 * @author Mazharul Islam
 */
public class review {

    protected static String allReview(String movieName) {
        movieName = movieName.replaceAll(" ", "_");
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/review/" + movieName + ".txt");
        if (f.exists()) {
            String ret = "";
            FileReader fr = null;
            BufferedReader br = null;
            try {
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                String line;
                boolean add = false;
                while ((line = br.readLine()) != null) {
                    if (add) {
                        ret += ",";
                    }
                    ret += line;
                    add = true;
                }
                return ret;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(review.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(review.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(review.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

        return "";

    }

    protected static void addReview(String movieName, String review) {
        movieName = movieName.replaceAll(" ", "_");
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/review/" + movieName + ".txt");
        FileWriter fr = null;
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(review.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            fr = new FileWriter(f, true);
            if (f.length() != 0) {
                fr.write("\n");
            }
            fr.write(review);

        } catch (IOException ex) {
            Logger.getLogger(review.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(review.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
