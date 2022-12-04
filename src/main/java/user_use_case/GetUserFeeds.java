package user_use_case;

import user.UserOutputBoundary;
import user.UserRequestModel;
import user.UserRepoGateway;

import java.io.IOException;
import java.util.List;

public class GetUserFeeds implements GetUserFeedsInputBoundary {

    private final UserOutputBoundary userOutputBoundary;

    private final UserRepoGateway userRepoGateway;

    public GetUserFeeds(UserOutputBoundary userOutputBoundary, UserRepoGateway userRepoGateway) {
        this.userOutputBoundary = userOutputBoundary;
        this.userRepoGateway = userRepoGateway;
    }

    @Override
    public List<Integer> getFeed(int userId) throws IOException {
        return userRepoGateway.getFeeds(userId);
    }

}
