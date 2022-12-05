package use_cases.user_use_case;

import controller_presenter_gateway.hompage_controller_presenter.HomePageOutputBoundary;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoRequestModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Login implements LoginInputBoundary {

    private final UserRepoGateway userRepoGateway;

    private final HomePageOutputBoundary homePageOutputBoundary;

    public Login(UserRepoGateway userRepoGateway, HomePageOutputBoundary homePageOutputBoundary) {
        this.userRepoGateway = userRepoGateway;
        this.homePageOutputBoundary = homePageOutputBoundary;
    }

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
