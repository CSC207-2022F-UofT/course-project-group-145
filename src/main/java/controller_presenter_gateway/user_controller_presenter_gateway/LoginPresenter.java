package controller_presenter_gateway.user_controller_presenter_gateway;

import ui.LoginViewInterface;

/**
 * Presenter that updates the log in screen
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewInterface loginViewInterface;

    /**
     * Creates a new LoginPresenter
     * @param loginViewInterface the interface for the log in view for this presenter to update
     */
    public LoginPresenter(LoginViewInterface loginViewInterface) {
        this.loginViewInterface = loginViewInterface;
    }

    /**
     * opens the log in screen
     */
    @Override
    public void open() {
        this.loginViewInterface.open();
    }
}
