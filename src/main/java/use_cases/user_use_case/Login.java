package use_cases.user_use_case;

import controller_presenter_gateway.hompage_controller_presenter.HomePageOutputBoundary;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoRequestModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Use case for verifying and logging in a user from the log in screen
 */
public class Login implements LoginInputBoundary {

    private final UserRepoGateway userRepoGateway;

    private final HomePageOutputBoundary homePageOutputBoundary;

    /**
     * Create a new Login use case instance
     * @param userRepoGateway user repository containing user data
     * @param homePageOutputBoundary presenter class that updates the home page
     */
    public Login(UserRepoGateway userRepoGateway, HomePageOutputBoundary homePageOutputBoundary) {
        this.userRepoGateway = userRepoGateway;
        this.homePageOutputBoundary = homePageOutputBoundary;
    }

    /**
     * Attempts to log in the user if the username and password are valid
     * will only succeed if username and password match those stored in user repository
     * @param username username of user attmepting to log in
     * @param password password of user attempting to log in
     */
    @Override
    public void login(String username, String password){
        Map<Integer, UserRepoRequestModel> users = this.userRepoGateway.getAllUsers();
        Set<Integer> ids = users.keySet();
        for (int id: ids) {
            UserRepoRequestModel user = users.get(id);
            if(username.equals(user.getUsername()) && password.equals((user.getPassword()))) {
                this.homePageOutputBoundary.openHome(user.getUserId());
            }
        }
    }

}
