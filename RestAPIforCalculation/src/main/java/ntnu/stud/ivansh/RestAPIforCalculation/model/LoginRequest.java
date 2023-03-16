package ntnu.stud.ivansh.RestAPIforCalculation.model;

public class LoginRequest {

    private String name;
    private String password;

    public LoginRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getUsername() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
