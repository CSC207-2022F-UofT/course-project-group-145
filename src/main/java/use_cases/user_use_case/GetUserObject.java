package use_cases.user_use_case;

import controller_presenter_gateway.user_controller_presenter_gateway.UserOutputBoundary;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoRequestModel;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;

import java.io.IOException;

public class GetUserObject implements GetUserObjectInputBoundary{

    private final UserOutputBoundary userOutputBoundary;

    private final UserRepoGateway userRepoGateway;

    public GetUserObject(UserOutputBoundary userOutputBoundary, UserRepoGateway userRepoGateway) {
        this.userOutputBoundary = userOutputBoundary;
        this.userRepoGateway = userRepoGateway;
    }

    @Override
    public UserRepoRequestModel getUserObject(int userId) throws IOException {
        return userRepoGateway.getUser(userId);
    }


}
