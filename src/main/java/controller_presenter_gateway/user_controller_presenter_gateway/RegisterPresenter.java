package controller_presenter_gateway.user_controller_presenter_gateway;

import ui.RegisterViewInterface;
/**
 * Presenter that updates the user register screen
 */
public class RegisterPresenter implements  RegisterOutputBoundary{

    private final RegisterViewInterface registerViewInterface;

    /**
     * Creates a new RegisterPresenter
     * @param registerViewInterface the view for this presenter to update
     */
    public RegisterPresenter(RegisterViewInterface registerViewInterface) {
        this.registerViewInterface = registerViewInterface;
    }

    /**
     * Opens the register screen
     */
    @Override
    public void open() {
        this.registerViewInterface.open();
    }
}
