package user_use_case;

import user.UserOutputBoundary;
import user.UserRequestModel;
import user.UserRepoGateway;

import java.io.IOException;

public class AddChatIdToMap implements AddChatIdToMapInputBoundary{

    private final UserOutputBoundary userOutputBoundary;

    private final UserRepoGateway userRepoGateway;

    public AddChatIdToMap(UserOutputBoundary userOutputBoundary, UserRepoGateway userRepoGateway) {
        this.userOutputBoundary = userOutputBoundary;
        this.userRepoGateway = userRepoGateway;
    }


    @Override
    public void addChatId(int chatId, UserRequestModel requestModel) throws IOException {
        userRepoGateway.addChatId(requestModel.getUserId(), chatId);
    }
}
