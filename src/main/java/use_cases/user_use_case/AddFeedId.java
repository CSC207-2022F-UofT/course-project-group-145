package use_cases.user_use_case;

import controller_presenter_gateway.user_controller_presenter_gateway.UserOutputBoundary;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRequestModel;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;

import java.io.IOException;

/**
 * Use case that adds a feed id to a user instance
 */
public class AddFeedId implements AddFeedIdInputBoundary{
    private final UserOutputBoundary userOutputBoundary;

    private final UserRepoGateway userRepoGateway;

    /**
     * Creates a new AddFeedId use case
     * @param userOutputBoundary user presenter class to update
     * @param userRepoGateway user repository instance to save to
     */
    public AddFeedId(UserOutputBoundary userOutputBoundary, UserRepoGateway userRepoGateway) {
        this.userOutputBoundary = userOutputBoundary;
        this.userRepoGateway = userRepoGateway;
    }

    /**
     * Called by controller to add a feed id to a given user
     * @param feedId id of feed to add
     * @param requestModel UserRequestModel containing information to be passed on to user repository to save
     * @throws IOException
     */
    @Override
    public void addFeedId(int feedId, UserRequestModel requestModel) throws IOException {
        userRepoGateway.addFeedId(requestModel.getUserId(), feedId);
    }


}
