package controller_presenter_gateway.hompage_controller_presenter;

import ui.HomePageViewInterface;

/**
 * Presenter for the homepage screen, updates the home page screen with results from use cases
 */
public class HomePagePresenter implements HomePageOutputBoundary {

    private final HomePageViewInterface homePageViewInterface;

    /**
     * Create the home page presenter with the given interfaces
     *
     * @param homePageViewInterface the interface for the home page UI
     */
    public HomePagePresenter(HomePageViewInterface homePageViewInterface) {
        this.homePageViewInterface = homePageViewInterface;
    }

    /**
     * Calls the home page UI interface to open the home page
     *
     * @param userId the user id
     */
    @Override
    public void openHome(int userId) {
        this.homePageViewInterface.openHomePage(userId);
    }
}
