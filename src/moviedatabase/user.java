package moviedatabase;

/**
 *
 * @author Mazharul Islam
 */
public class user {

    private String username, password;

    public user(String user, String pass) {
        this.username = user;
        this.password = pass;
    }

    public user() {
        this.username = null;
        this.password = null;
    }

    @Override
    public String toString() {
        return this.username + " " + this.password;
    }

}
