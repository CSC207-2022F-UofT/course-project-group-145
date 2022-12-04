package controller_presenter_gateway.hompage_controller_presenter;

import use_cases.homepage_use_cases.OpenChatListInputBoundary;

public class HomePageController {

    private final OpenChatListInputBoundary openChatListInputBoundary;

    /**
     * Create the home page controller with given use cases
     *
     * @param openChatListInputBoundary the open chat list use case input boundary
     */
    public HomePageController(OpenChatListInputBoundary openChatListInputBoundary) {
        this.openChatListInputBoundary = openChatListInputBoundary;
    }

    /**
     * Calls the use case to open the chat list
     *
     * @param userId the user id
     */
    public void openList(int userId) {
        this.openChatListInputBoundary.openList(userId);
    }

    public void logOut() {

    }
}
