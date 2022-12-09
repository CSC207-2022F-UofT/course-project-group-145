package controller_presenter_gateway.hompage_controller_presenter;

import controller_presenter_gateway.user_controller_presenter_gateway.LoginOutputBoundary;
import use_cases.feed_use_case.OpenFeedListInputBoundary;
import use_cases.feed_use_case.OpenFeedListUseCase;
import use_cases.homepage_use_cases.OpenChatListInputBoundary;

import java.io.IOException;

/**
 * Controller that handles inputs from the home page
 */
public class HomePageController {

    private final OpenChatListInputBoundary openChatListInputBoundary;

    private final LoginOutputBoundary loginOutputBoundary;

    private final OpenFeedListInputBoundary openFeedListInputBoundary;

    /**
     * Create the home page controller with given use cases
     *
     * @param openChatListInputBoundary the open chat list use case input boundary
     */
    public HomePageController(OpenChatListInputBoundary openChatListInputBoundary, LoginOutputBoundary loginOutputBoundary, OpenFeedListInputBoundary openFeedListInputBoundary) {
        this.openChatListInputBoundary = openChatListInputBoundary;
        this.loginOutputBoundary = loginOutputBoundary;
        this.openFeedListInputBoundary = openFeedListInputBoundary;
    }

    /**
     * Calls the use case to open the chat list
     *
     * @param userId the user id
     */
    public void openList(int userId) throws IOException {
        this.openChatListInputBoundary.openList(userId);
    }

    /**
     * Logs out by calling the presenter for the login page
     */
    public void logOut() {
        this.loginOutputBoundary.open();
    }

    public void openFeedList(int userID){
        this.openFeedListInputBoundary.open(userID);
    }
}
