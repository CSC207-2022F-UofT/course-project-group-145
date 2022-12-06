package use_cases.user_use_case;

import controller_presenter_gateway.user_controller_presenter_gateway.UserOutputBoundary;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRequestModel;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;

import java.io.IOException;

public class AddFeedId implements AddFeedIdInputBoundary{
    private final UserOutputBoundary userOutputBoundary;

    private final UserRepoGateway userRepoGateway;

    public AddFeedId(UserOutputBoundary userOutputBoundary, UserRepoGateway userRepoGateway) {
        this.userOutputBoundary = userOutputBoundary;
        this.userRepoGateway = userRepoGateway;
    }


    @Override
    public void addFeedId(int feedId, UserRequestModel requestModel) throws IOException {
        userRepoGateway.addFeedId(requestModel.getUserId(), feedId);
    }


}
