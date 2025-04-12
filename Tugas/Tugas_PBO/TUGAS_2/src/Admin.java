public class Admin {
    String username = "admin444";
    String password = "password444";

    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }
}
