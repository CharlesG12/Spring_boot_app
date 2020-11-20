package com.charles.app.ws.ui.model.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateDetialsRequestModel {
    @Valid
    @NotNull(message="First name cannot be Null")
    @Size(min=2, message = "First name must be no less than 2 character")
    private String firstName;

    @Valid
    @NotNull(message="lastName cannot be Null")
    @Size(min=2, message = "Last name must be no less than 2 character")
    private String lastName;

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
}
