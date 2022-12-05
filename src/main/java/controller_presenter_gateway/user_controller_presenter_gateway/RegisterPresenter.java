package controller_presenter_gateway.user_controller_presenter_gateway;

import ui.RegisterViewInterface;

public class RegisterPresenter implements  RegisterOutputBoundary{

    private final RegisterViewInterface registerViewInterface;

    public RegisterPresenter(RegisterViewInterface registerViewInterface) {
        this.registerViewInterface = registerViewInterface;
    }

    @Override
    public void open() {
        this.registerViewInterface.open();
    }
}
