package use_cases.user_use_case;

import controller_presenter_gateway.user_controller_presenter_gateway.UserOutputBoundary;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRequestModel;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;

import java.io.IOException;

/**
 * Use case that adds a chat to a user
 */
public class AddChatIdToMap implements AddChatIdToMapInputBoundary{

    private final UserOutputBoundary userOutputBoundary;

    private final UserRepoGateway userRepoGateway;

    /**
     * Creates a new AddChatIdToMap use case
     * @param userOutputBoundary presenter object to send to
     * @param userRepoGateway user repository instance to save user data
     */
    public AddChatIdToMap(UserOutputBoundary userOutputBoundary, UserRepoGateway userRepoGateway) {
        this.userOutputBoundary = userOutputBoundary;
        this.userRepoGateway = userRepoGateway;
    }

    /**
     * Adds given chatID to user entry in persistent
     * @param chatId id of chat to add to user
     * @param requestModel request model that contains required info for persistence to log user
     * @throws IOException
     */
    @Override
    public void addChatId(int chatId, UserRequestModel requestModel) throws IOException {
        userRepoGateway.addChatId(requestModel.getUserId(), chatId);
    }
}
