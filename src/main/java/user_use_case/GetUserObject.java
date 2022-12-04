package user_use_case;

import user.UserOutputBoundary;
import user.UserRepoRequestModel;
import user.UserRequestModel;
import user.UserRepoGateway;

import java.io.IOException;
import java.util.List;

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
