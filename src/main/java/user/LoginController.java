package user;

import user_use_case.LoginInputBoundary;

public class LoginController {

    private final LoginInputBoundary loginInputBoundary;

    public LoginController(LoginInputBoundary loginInputBoundary){
        this.loginInputBoundary = loginInputBoundary;
    }

    public void login(String username, String password){

    }
}
