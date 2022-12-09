package controller_presenter_gateway.feed_interaction_controller_presenter_gateway;

import use_cases.homepage_use_cases.OpenHomePageInputBoundary;

/**
 * Controller for handling user input from home button on DetailedFeedView
 */
public class FeedInteractionHomeController {
    private OpenHomePageInputBoundary openHome;
    public FeedInteractionHomeController(OpenHomePageInputBoundary openHome){
        this.openHome = openHome;
    }

    /**
     * Returns to the home page by calling the OpenHomePageInteractor
     * @param userID use case of user currently logged in
     */
    public void goHome(int userID){
        openHome.openHome(userID);
    }
}
