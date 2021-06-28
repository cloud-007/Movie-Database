package moviedatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class adminUser extends user {

    adminUser() {
        super(null, null);
    }

    adminUser(String s, String p) {
        super(s, p);
    }

    protected static boolean add(String user, String pass) {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/adminUser.txt");
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
                if (userName.equals(user)) {
                    return false;
                }
            }

            FileWriter fw = new FileWriter(f, true);
            if (f.length() != 0) {
                fw.write("\n");
            }
            fw.write(user + "," + pass);
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

    protected static boolean checkAdmin(String name, String pwd) {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/adminUser.txt");
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

    protected static boolean banUser(String name) {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/normalUser.txt");
        File ff = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/bannedUser.txt");
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter FR = null;
        File file = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/mytext.txt");
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            FR = new FileWriter(file);
            FileWriter FFR = new FileWriter(ff, true);
            String line;
            boolean newline = false, notfound = true;
            while ((line = br.readLine()) != null) {
                String Temp[] = line.split(",");
                String userName = Temp[0];
                String password = Temp[1];
                if (!userName.equals(name)) {
                    if (newline) {
                        FR.write("\n");
                    }
                    FR.write(userName + "," + password);
                    newline = true;
                } else {
                    notfound = false;
                    if (ff.length() != 0) {
                        FFR.write("\n");
                    }
                    FFR.write(userName);
                    FFR.close();
                }
            }
            FR.close();

            if (notfound) {
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
                file.renameTo(new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/normalUser.txt"));
            } catch (IOException ex) {
                Logger.getLogger(adminUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return true;

    }

    protected static boolean removeAdmin(String name) {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/adminUser.txt");
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
                String userName = Temp[0];
                String password = Temp[1];
                if (!userName.equals(name)) {
                    if (newline) {
                        FR.write("\n");
                    }
                    FR.write(userName + "," + password);
                    newline = true;
                } else {
                    notfound = false;
                }
            }
            FR.close();
            if (notfound) {
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
                file.renameTo(new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/adminUser.txt"));
            } catch (IOException ex) {
                Logger.getLogger(adminUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    protected static boolean banCheck(String name) {
        File f = new File("C:\\Users\\Mazharul Islam\\Documents\\NetBeansProjects\\MovieDatabase\\src/bannedUser.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String Temp[] = line.split(",");
                String userName = Temp[0];
                if (userName.equals(name)) {
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

}
