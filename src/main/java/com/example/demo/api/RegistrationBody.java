package com.example.demo.api;

import jakarta.validation.constraints.*;

public class RegistrationBody {
    @NotNull
    @NotBlank
    @Size(min = 4, max = 32)
    private String username;

    @Email
    @NotNull
    @NotBlank
    @Size(min = 4, max = 320)

    private String email;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 32)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")
    private String password;

    @NotNull
    @NotBlank
    @Size(min = 2,max=32)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 2,max=32)
    private String lastName;



    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
