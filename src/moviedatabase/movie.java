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
public class movie {

    private String name, genre, director, length, rating, url;

    public movie(String name, String genre, String director, String length, String rating, String url) {
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.length = length;
        this.rating = rating;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getLength() {
        return length;
    }

    public String getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    protected static boolean add(String name, String genre, String director, String length, String rating, String url) {

        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieList.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String Temp[] = line.split(",");
                if (name.equals(Temp[0])) {
                    return false;
                }
            }

            FileWriter fw = new FileWriter(f, true);
            if (f.length() != 0) {
                fw.write("\n");
            }
            if (url.length() == 0) {
                url = "nothing";
            }
            fw.write(name.toUpperCase() + "," + genre.toUpperCase() + "," + director.toUpperCase() + "," + length + "," + rating + "," + url);
            fw.close();
            fr.close();

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

    protected static String checkMovie(String name) {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieList.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String Temp[] = line.split(",");
                if (name.equals(Temp[0])) {
                    return line;
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
        return null;
    }

    protected static boolean deleteMovieorRequest(String name, int type) {
        File f = null;
        if (type == 1) {
            f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieList.txt");
        } else {
            f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieRequest.txt");
        }
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter FR = null;
        File file = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/mytext.txt");
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            FR = new FileWriter(file);
            String line;
            boolean newline = false, notfound = true;
            while ((line = br.readLine()) != null) {
                String Temp[] = line.split("\\,");
                String movieName = Temp[0];
                if (!movieName.equals(name)) {
                    if (newline) {
                        FR.write('\n');
                    }
                    FR.write(line);
                    newline = true;
                } else {
                    notfound = false;
                }
            }
            FR.close();
            fr.close();

            if (notfound && type == 1) {
                return false;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(adminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
                f.delete();
                if (type == 2) {
                    file.renameTo(new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieRequest.txt"));
                } else {
                    file.renameTo(new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieList.txt"));
                }
            } catch (IOException ex) {
                Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return true;
    }

    protected static void deleteRequest(String s) {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieRequest.txt");
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter FR = null;
        File file = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/mytext.txt");
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            FR = new FileWriter(file);
            String line;
            boolean newline = false;
            while ((line = br.readLine()) != null) {
                String Temp[] = line.split("\\,");
                String movie = Temp[0];
                if (!movie.equals(s)) {
                    if (newline) {
                        FR.write("\n");
                    }
                    FR.write(movie);
                    newline = true;
                }
            }
            FR.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(adminUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(adminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
                f.delete();
                file.renameTo(new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieRequest.txt"));
            } catch (IOException ex) {
                Logger.getLogger(adminUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    protected static boolean countMovie() {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieList.txt");
        return f.length() != 0;
    }

    protected static String allMovie() {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieList.txt");
        f = new File(f.getAbsoluteFile().toString());
        FileReader fr = null;
        BufferedReader br = null;
        String ret = "";
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            boolean add = false;
            while ((line = br.readLine()) != null) {
                if (add) {
                    ret += "+";
                }
                ret += line;
                add = true;
            }
            return ret;

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

        return "";
    }

    protected static String getRating(float start, float end) {
        if (start > end) {
            float f = start;
            start = end;
            end = f;
        }
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieList.txt");
        FileReader fr = null;
        BufferedReader br = null;
        String ret = "";
        boolean notfound = true;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            boolean add = false;
            while ((line = br.readLine()) != null) {
                String temp[] = line.split(",");
                float rating = Float.parseFloat(temp[4]);
                if (rating >= start && rating <= end) {
                    if (add) {
                        ret += "+";
                    }
                    ret += line;
                    add = true;
                    notfound = false;
                }

            }
            if (notfound) {
                return "NOTHING";
            }
            return ret;

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

        return "NOTHING";
    }

    protected static String getGenreOrDirector(String s, int type) {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieList.txt");
        FileReader fr = null;
        BufferedReader br = null;
        String ret = "";
        boolean notfound = true;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            boolean add = false;
            while ((line = br.readLine()) != null) {
                String temp[] = line.split(",");
                if (type == 1) {
                    if (temp[1].equals(s)) {
                        notfound = false;
                        if (add) {
                            ret += "+";
                        }
                        ret += line;
                        add = true;
                    }
                } else {
                    if (temp[2].equals(s)) {
                        notfound = false;
                        if (add) {
                            ret += "+";
                        }
                        ret += line;
                        add = true;
                    }
                }

            }
            if (notfound) {
                return "NOTHING";
            }
            return ret;

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

        return "NOTHING";
    }

    protected static boolean requestExists(String s) {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieRequest.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() != 0 && line.equals(s)) {
                    return true;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

    protected static void movieRequest(String s) {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieRequest.txt");
        FileWriter fr = null;
        try {
            if (movie.requestExists(s)) {
                return;
            }
            fr = new FileWriter(f, true);
            if (f.length() != 0) {
                fr.write('\n');
            }
            fr.write(s);
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected static String allMovieRequest() {
        String s = "";
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/movieRequest.txt");
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String line;

            boolean add = false;

            while ((line = br.readLine()) != null) {
                if (add) {
                    s += ",";
                }
                s += line;
                add = true;
            }

            return s;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(movie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return s;
    }

}
