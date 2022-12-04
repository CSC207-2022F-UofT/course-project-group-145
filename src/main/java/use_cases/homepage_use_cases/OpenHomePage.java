package use_cases.homepage_use_cases;

import controller_presenter_gateway.hompage_controller_presenter.HomePageOutputBoundary;

public class OpenHomePage implements OpenHomePageInputBoundary {

    private final HomePageOutputBoundary homePageOutputBoundary;

    /**
     * Create the open home page use case with given interfaces
     *
     * @param homePageOutputBoundary the output boundary for the homepage
     */
    public OpenHomePage(HomePageOutputBoundary homePageOutputBoundary) {
        this.homePageOutputBoundary = homePageOutputBoundary;
    }

    /**
     * Calls output boundary to open the homepage of user
     *
     * @param userId the user id of current user
     */
    public void openHome(int userId) {
        homePageOutputBoundary.openHome(userId);
    }
}
