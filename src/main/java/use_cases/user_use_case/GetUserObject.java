package use_cases.user_use_case;

import controller_presenter_gateway.user_controller_presenter_gateway.UserOutputBoundary;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoRequestModel;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;

import java.io.IOException;

/**
 * Use case for retrieveing the user object from user repository
 */
public class GetUserObject implements GetUserObjectInputBoundary{

    private final UserOutputBoundary userOutputBoundary;

    private final UserRepoGateway userRepoGateway;

    /**
     * Creates a new GetUserObject use case instance
     * @param userOutputBoundary presenter class this use case will update
     * @param userRepoGateway user repository that this use case will get info from
     */
    public GetUserObject(UserOutputBoundary userOutputBoundary, UserRepoGateway userRepoGateway) {
        this.userOutputBoundary = userOutputBoundary;
        this.userRepoGateway = userRepoGateway;
    }

    /**
     * Get data to create user enitty object from user repo of user specified by user id
     * @param userId id of user whose data to retrieve
     * @return UserRepoRequestModel containing all info needed to create a new user entity object
     * @throws IOException
     */
    @Override
    public UserRepoRequestModel getUserObject(int userId) throws IOException {
        return userRepoGateway.getUser(userId);
    }


}
