package controller_presenter_gateway.hompage_controller_presenter;

import controller_presenter_gateway.user_controller_presenter_gateway.LoginOutputBoundary;
import use_cases.homepage_use_cases.OpenChatListInputBoundary;

import java.io.IOException;

public class HomePageController {

    private final OpenChatListInputBoundary openChatListInputBoundary;

    private final LoginOutputBoundary loginOutputBoundary;

    /**
     * Create the home page controller with given use cases
     *
     * @param openChatListInputBoundary the open chat list use case input boundary
     */
    public HomePageController(OpenChatListInputBoundary openChatListInputBoundary, LoginOutputBoundary loginOutputBoundary) {
        this.openChatListInputBoundary = openChatListInputBoundary;
        this.loginOutputBoundary = loginOutputBoundary;
    }

    /**
     * Calls the use case to open the chat list
     *
     * @param userId the user id
     */
    public void openList(int userId) throws IOException {
        this.openChatListInputBoundary.openList(userId);
    }

    public void logOut() {
        this.loginOutputBoundary.open();
    }
}
