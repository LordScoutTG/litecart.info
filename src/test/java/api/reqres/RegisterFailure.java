package api.reqres;

public class RegisterFailure {
    private String email;

    public RegisterFailure(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
