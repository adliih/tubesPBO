
public class Member extends Orang {

    private String username, password;

    public Member(String username, String password, String nama, int umur) {
        super(nama, umur);
        this.username = username;
        this.password = password;
    }

    /**
     *
     * Set Username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    @Override
    public String getStatus() {
        return "Member";
    }
}
