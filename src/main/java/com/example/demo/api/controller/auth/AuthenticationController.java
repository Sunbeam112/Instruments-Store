package com.example.demo.api.controller.auth;


import com.example.demo.api.RegistrationBody;
import com.example.demo.exception.EmailFailureException;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotVerifiedException;
import com.example.demo.model.LocalUser;
import com.example.demo.model.LoginBody;
import com.example.demo.model.LoginResponse;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;
    private final ResourcePatternResolver resourcePatternResolver;

    public AuthenticationController(UserService userService, ResourcePatternResolver resourcePatternResolver) {
        this.userService = userService;
        this.resourcePatternResolver = resourcePatternResolver;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody) {
        try {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EmailFailureException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody) throws UserNotVerifiedException, EmailFailureException {
        String jwt = null;
        try {
            jwt = userService.loginUser(loginBody);
        } catch (EmailFailureException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (UserNotVerifiedException ex) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setSuccess(Boolean.FALSE);
            String reason = "USER_NOT_VERIFIED";
            if (ex.isNewEmailSent()) {
                reason = "_EMAIL_RESENT";
            }
            loginResponse.setFailureReason(reason);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(loginResponse);
        }
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setJwt(jwt);
            loginResponse.setSuccess(Boolean.TRUE);
            return ResponseEntity.ok(loginResponse);
        }
    }


    @PostMapping("/verify")
    public ResponseEntity<LoginResponse> verifyUser(@RequestParam String token) {
        if (userService.verifyUser(token)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/me")
    public LocalUser getLoggedInUserProfile(@AuthenticationPrincipal LocalUser user) {
        return user;
    }
}
