package use_cases.user_use_case;

import controller_presenter_gateway.user_controller_presenter_gateway.UserOutputBoundary;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;

import java.io.IOException;

public class DeleteUser implements DeleteUserInputBoundary{

    private final UserOutputBoundary UserOutputBoundary;

    private final UserRepoGateway UserRepoGateway;

    public DeleteUser(UserOutputBoundary UserOutputBoundary, UserRepoGateway UserRepoGateway) {
        this.UserOutputBoundary = UserOutputBoundary;
        this.UserRepoGateway = UserRepoGateway;
    }
    @Override
    public void delete(int userId) throws IOException {
        UserRepoGateway.delete(userId);
    }
}