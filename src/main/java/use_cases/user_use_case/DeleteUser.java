package use_cases.user_use_case;

import controller_presenter_gateway.user_controller_presenter_gateway.UserOutputBoundary;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;

import java.io.IOException;

/**
 * Use case that deletes a user from the user repository
 */
public class DeleteUser implements DeleteUserInputBoundary{

    private final UserOutputBoundary UserOutputBoundary;

    private final UserRepoGateway UserRepoGateway;

    /**
     * Creates a new DeleteUser use case instance
     * @param UserOutputBoundary presenter class to update with success/failure
     * @param UserRepoGateway user repository to save data to
     */
    public DeleteUser(UserOutputBoundary UserOutputBoundary, UserRepoGateway UserRepoGateway) {
        this.UserOutputBoundary = UserOutputBoundary;
        this.UserRepoGateway = UserRepoGateway;
    }

    /**
     * Call to delete a user from the user repository
     * is a soft delete, thus sets the isDeleted boolean tag in the user in repo to True
     * @param userId id of user to delete
     * @throws IOException
     */
    @Override
    public void delete(int userId) throws IOException {
        UserRepoGateway.delete(userId);
    }
}