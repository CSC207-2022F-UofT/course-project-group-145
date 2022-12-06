package controller_presenter_gateway.user_controller_presenter_gateway;

import ui.LoginViewInterface;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewInterface loginViewInterface;

    public LoginPresenter(LoginViewInterface loginViewInterface) {
        this.loginViewInterface = loginViewInterface;
    }

    @Override
    public void open() {
        this.loginViewInterface.open();
    }
}
