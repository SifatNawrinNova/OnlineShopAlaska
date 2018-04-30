package data.model;

public class Login {

   private  String Username;
   private String Password;
   private String log_exp;

    public Login() {
    }

    public String getLog_exp() {
        return log_exp;
    }

    public void setLog_exp(String log_exp) {
        this.log_exp = log_exp;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
