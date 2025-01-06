package javaproject.desktop.dtos.requests;

public class UserRequest {
    private String email;
    private String password;

    public UserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toJSonString() {
        return STR."{\"email\":\"\{email != null ? email : ""}\",\"password\":\"\{password != null ? password : ""}\"}";
    }
}
