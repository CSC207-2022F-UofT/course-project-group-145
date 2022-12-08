package use_cases.user_use_case;

import controller_presenter_gateway.user_controller_presenter_gateway.UserOutputBoundary;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;

import java.io.IOException;
import java.util.List;

/**
 * Use case to get the id of feeds of a user from user repository
 */
public class GetUserFeeds implements GetUserFeedsInputBoundary {

    private final UserOutputBoundary userOutputBoundary;

    private final UserRepoGateway userRepoGateway;

    /**
     * Creates a new GetUserFeeds use case instance
     * @param userOutputBoundary presenter that implements UserOutputBoundary for this use case to update
     * @param userRepoGateway user repository to get user information from
     */
    public GetUserFeeds(UserOutputBoundary userOutputBoundary, UserRepoGateway userRepoGateway) {
        this.userOutputBoundary = userOutputBoundary;
        this.userRepoGateway = userRepoGateway;
    }

    /**
     * Get feed ids belonging to given user from user repository
     * @param userId id of user
     * @return list of feed ids
     * @throws IOException
     */
    @Override
    public List<Integer> getFeed(int userId) throws IOException {
        return userRepoGateway.getFeeds(userId);
    }

}
