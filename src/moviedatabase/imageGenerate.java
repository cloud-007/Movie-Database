/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatabase;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Mazharul Islam
 */
public class imageGenerate {

    protected static Image checkUrl(String s) {
        try {
            BufferedImage image = ImageIO.read(new URL(s));
            //BufferedImage image = ImageIO.read(new URL("http://someimage.jpg"));\
           // System.out.println(image);
            if (image != null) {
                return image;
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
    
    public Image getDefault(){
        Image img = null;
        try {
            img = ImageIO.read(getClass().getResource("/moviedatabase/Images/defaultImage.jpg"));
        } catch (IOException ex) {
            return null;
        }
        
        return img;
    }
    
    
}
