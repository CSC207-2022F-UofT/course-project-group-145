package controller_presenter_gateway.user_controller_presenter_gateway;

import use_cases.user_use_case.LoginInputBoundary;

public class LoginController {

    private final LoginInputBoundary loginInputBoundary;

    private final RegisterOutputBoundary registerOutputBoundary;

    public LoginController(LoginInputBoundary loginInputBoundary,
                           RegisterOutputBoundary registerOutputBoundary){
        this.loginInputBoundary = loginInputBoundary;
        this.registerOutputBoundary = registerOutputBoundary;
    }

    public void login(String username, String password){
        this.loginInputBoundary.login(username, password);
    }

    public void openRegister() {
        this.registerOutputBoundary.open();
    }
}
