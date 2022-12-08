package controller_presenter_gateway.user_controller_presenter_gateway;

import use_cases.user_use_case.LoginInputBoundary;

/**
 * Controller that passes input data from the login screen to the log in and also can open the register screen
 */
public class LoginController {

    private final LoginInputBoundary loginInputBoundary;

    private final RegisterOutputBoundary registerOutputBoundary;

    /**
     * Creates a new LoginController
     * @param loginInputBoundary instance of the log in use case
     * @param registerOutputBoundary instance of the register use case
     */
    public LoginController(LoginInputBoundary loginInputBoundary,
                           RegisterOutputBoundary registerOutputBoundary){
        this.loginInputBoundary = loginInputBoundary;
        this.registerOutputBoundary = registerOutputBoundary;
    }

    /**
     * Calls the log in use case
     * @param username username of user
     * @param password password of user
     */
    public void login(String username, String password){
        this.loginInputBoundary.login(username, password);
    }

    /**
     * opens the register new user screen
     */
    public void openRegister() {
        this.registerOutputBoundary.open();
    }
}
