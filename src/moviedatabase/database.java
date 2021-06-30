/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mazharul Islam
 */
public class database {

    public static void insertAdminOrNormalUser(String username, String pass, int idx) {
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert;
            if (idx == 1) {
                insert = "INSERT INTO mydatabase.adminuser (username, password) VALUES ('" + username + "', '" + pass + "');";
            } else {
                insert = "INSERT INTO mydatabase.normaluser (username, password) VALUES ('" + username + "', '" + pass + "');";
            }
            myStmt.executeUpdate(insert);
            myConn.close();
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        }
    }

    public static void addMovieRequest(String name) {
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "INSERT INTO mydatabase.movierequest (moviename) VALUES ('" + name + "');";
            myStmt.executeUpdate(insert);
            myConn.close();
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        }
    }

    public static boolean adminOrNormalExists(String username, int idx) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert;
            if (idx == 1) {
                insert = "SELECT * FROM mydatabase.adminuser WHERE username = '" + username + "';";
            } else {
                insert = "SELECT * FROM mydatabase.normaluser WHERE username = '" + username + "';";
            }
            ResultSet myRs = myStmt.executeQuery(insert);
            boolean found = false;
            while (myRs.next()) {
                found = true;
            }
            myConn.close();
            return found;
        } catch (SQLException exc) {
            System.out.println("Nothing found");
            return false;
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean validAdminOrNormal(String username, String password, int idx) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert;
            if (idx == 1) {
                insert = "SELECT * FROM mydatabase.adminuser WHERE username = '" + username + "';";
            } else {
                insert = "SELECT * FROM mydatabase.normaluser WHERE username = '" + username + "';";
            }
            ResultSet myRs = myStmt.executeQuery(insert);
            boolean found = false;
            String cur = "";
            while (myRs.next()) {
                found = true;
                cur = myRs.getString("password");
            }
            myConn.close();
            return password.equals(cur);
        } catch (SQLException exc) {
            System.out.println("Nothing found");
            return false;
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void addBannedUser(String name) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "INSERT INTO mydatabase.banneduser (username) VALUES ('" + name + "');";
            myStmt.executeUpdate(insert);
            myConn.close();
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean bannedUser(String username) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "SELECT * FROM mydatabase.bannedUser WHERE username = '" + username + "';";

            ResultSet myRs = myStmt.executeQuery(insert);
            boolean found = false;
            String cur = "";
            while (myRs.next()) {
                found = true;
            }
            myConn.close();
            return found;
        } catch (SQLException exc) {
            System.out.println("Nothing found");
            return false;
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void deleteAdminOrNormal(String username, int idx) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert;
            if (idx == 1) {
                insert = "DELETE FROM mydatabase.adminuser WHERE username = '" + username + "';";
            } else {
                insert = "DELETE FROM mydatabase.normaluser WHERE username ='" + username + "';";
            }
            //System.out.println(insert);
            myStmt.executeUpdate(insert);
            myConn.close();
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void addMovie(String name, String genre, String director, String length, String rating, String url) {
        if (url.length() == 0) {
            url = "nothing";
        }
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "INSERT INTO mydatabase.moviedetails (name, genre, director, length, rating, url) VALUES ('"
                    + name + "','" + genre + "','" + director + "','" + Float.parseFloat(length) + "','" + Float.parseFloat(rating)
                    + "', '" + url + "');";
            //System.out.println(insert);
            myStmt.executeUpdate(insert);
            myConn.close();
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean checkMovie(String s) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert;
            insert = "SELECT * FROM mydatabase.moviedetails WHERE name = '" + s + "';";
            ResultSet myRs = myStmt.executeQuery(insert);
            boolean found = false;
            while (myRs.next()) {
                found = true;
            }
            myConn.close();
            return found;
        } catch (SQLException exc) {
            System.out.println("Nothing found");
            return false;
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean movieRequestExists(String name) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "SELECT * FROM mydatabase.movierequest WHERE moviename = '" + name + "';";
            ResultSet myRs = myStmt.executeQuery(insert);
            boolean found = false;
            while (myRs.next()) {
                found = true;
            }
            myConn.close();
            return found;
        } catch (SQLException exc) {
            System.out.println("Nothing found");
            return false;
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void deleteMovieOrRequest(String s, int idx) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert;
            if (idx == 1) {
                insert = "DELETE FROM mydatabase.moviedetails WHERE name = '" + s + "';";
            } else {
                insert = "DELETE FROM mydatabase.movierequest WHERE moviename = '" + s + "';";
            }
            System.out.println(insert);
            myStmt.executeUpdate(insert);
            myConn.close();
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String getMovieDetails(String s) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "SELECT * FROM mydatabase.moviedetails WHERE name = '" + s + "';";
            ResultSet myRs = myStmt.executeQuery(insert);
            String cur = "";
            while (myRs.next()) {
                cur += myRs.getString("name");
                cur += ",";
                cur += myRs.getString("genre");
                cur += ",";
                cur += myRs.getString("director");
                cur += ",";
                cur += String.valueOf(myRs.getString("length"));
                cur += ",";
                cur += String.valueOf(myRs.getString("rating"));
                cur += ",";
                cur += myRs.getString("url");
            }
            myConn.close();
            return cur;
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    public static String requestedMovie() {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "SELECT * FROM mydatabase.movierequest;";
            ResultSet myRs = myStmt.executeQuery(insert);
            String cur = "";
            boolean add = false;
            while (myRs.next()) {
                if (add) {
                    cur += ",";
                }
                cur += myRs.getString("moviename");
                add = true;
            }
            myConn.close();
            return cur;
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    public static String getAllMovie() {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "SELECT * FROM mydatabase.moviedetails;";
            ResultSet myRs = myStmt.executeQuery(insert);
            String cur = "";
            boolean add = false;
            while (myRs.next()) {
                if (add) {
                    cur += "+";
                }
                cur += myRs.getString("name");
                cur += ",";
                cur += myRs.getString("genre");
                cur += ",";
                cur += myRs.getString("director");
                cur += ",";
                cur += String.valueOf(myRs.getString("length"));
                cur += ",";
                cur += String.valueOf(myRs.getString("rating"));
                cur += ",";
                cur += myRs.getString("url");
                add = true;
            }
            myConn.close();
            return cur;
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    public static String getGenreOrDirector(String name, int type) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "SELECT * FROM mydatabase.moviedetails;";
            ResultSet myRs = myStmt.executeQuery(insert);
            String cur = "";
            boolean add = false;
            while (myRs.next()) {
                if ((type == 1 && myRs.getString("genre").equals(name))
                        || (type == 2 && myRs.getString("director").equals(name))) {
                    if (add) {
                        cur += "+";
                    }
                    cur += myRs.getString("name");
                    cur += ",";
                    cur += myRs.getString("genre");
                    cur += ",";
                    cur += myRs.getString("director");
                    cur += ",";
                    cur += String.valueOf(myRs.getString("length"));
                    cur += ",";
                    cur += String.valueOf(myRs.getString("rating"));
                    cur += ",";
                    cur += myRs.getString("url");
                    add = true;
                }
            }
            myConn.close();
            if (cur.length() == 0) {
                cur = "NOTHING";
            }
            return cur;
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "NOTHING";
    }

    public static boolean tableExists(String name) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "SELECT * FROM mydatabase." + name + ";";
            ResultSet myRs = myStmt.executeQuery(insert);
            boolean found = false;
            while (myRs.next()) {
                found = true;
            }
            myConn.close();
            return found;
        } catch (SQLException exc) {
            System.out.println("Nothing found");
            return false;
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void addReview(String moviename, String review) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "INSERT INTO mydatabase." + moviename + "(review) VALUES ('" + review + "');";
            myStmt.executeUpdate(insert);
            myConn.close();
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void createTable(String name) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "CREATE TABLE " + name + " LIKE mydatabase.defaultreview;";
            //System.out.println(insert);
            myStmt.executeUpdate(insert);
            myConn.close();
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String getRating(float start, float end) {
        //System.out.println(start + " " + end);
        if (start > end) {
            float x = end;
            end = start;
            start = x;
        }
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "SELECT * FROM mydatabase.moviedetails;";
            ResultSet myRs = myStmt.executeQuery(insert);
            String cur = "";
            boolean add = false;
            while (myRs.next()) {
                float f = Float.parseFloat(myRs.getString("rating"));
                if (f >= start && f <= end) {
                    if (add) {
                        cur += "+";
                    }
                    cur += myRs.getString("name");
                    cur += ",";
                    cur += myRs.getString("genre");
                    cur += ",";
                    cur += myRs.getString("director");
                    cur += ",";
                    cur += String.valueOf(myRs.getString("length"));
                    cur += ",";
                    cur += String.valueOf(myRs.getString("rating"));
                    cur += ",";
                    cur += myRs.getString("url");
                    add = true;
                }
            }
            myConn.close();
            if (cur.length() == 0) {
                cur = "NOTHING";
            }
            return cur;
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "NOTHING";
    }

    public static String getReview(String moviename) {
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "12345");
            Statement myStmt = myConn.createStatement();
            String insert = "SELECT * FROM mydatabase." + moviename + ";";
            ResultSet myRs = myStmt.executeQuery(insert);
            String cur = "";
            boolean add = false;
            while (myRs.next()) {
                if (add) {
                    cur += ",";
                }
                cur += myRs.getString("review");
                add = true;
            }
            ///  System.out.println(cur);
            myConn.close();
            return cur;
        } catch (SQLException exc) {
            System.out.println("Nothing found");
        } finally {
            try {
                myConn.close();
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

}

/*
    IF (EXISTS (SELECT * 
                 FROM INFORMATION_SCHEMA.TABLES 
                 WHERE TABLE_SCHEMA = 'TheSchema' 
                 AND  TABLE_NAME = 'TheTable'))
    
 */
