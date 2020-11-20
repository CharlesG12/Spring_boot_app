package com.charles.app.ws.ui.model.request;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetialsRequestModel {

    @Valid
    @NotNull(message="First name cannot be Null")
    @Size(min=2, message = "First name must be no less than 2 character")
    private String firstName;

    @Valid
    @NotNull(message="lastName cannot be Null")
    @Size(min=2, message = "Last name must be no less than 2 character")
    private String lastName;

    @Valid
    @NotNull(message="email cannot be Null")
    @Email
    private String email;

    @Valid
    @NotNull(message="password cannot be Null")
    @Size(min = 8, max = 16, message = "password must be equal or greater than 8 but smaller than 16")
    private String password;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    private String userid;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
