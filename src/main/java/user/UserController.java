package user;

import user_use_case.AddUserInputBoundary;
import user_use_case.DeleteUserInputBoundary;
import user_use_case.GetUserFeedsInputBoundary;
import user_use_case.GetUserObjectInputBoundary;
import user_use_case.AddChatIdToMapInputBoundary;
import user_use_case.AddFeedIdInputBoundary;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserController {

    private final AddUserInputBoundary addUserInputBoundary;

    private final DeleteUserInputBoundary deleteUserInputBoundary;

    private final GetUserFeedsInputBoundary getUserFeedsInputBoundary;

    private final GetUserObjectInputBoundary getUserObjectInputBoundary;

    private final AddChatIdToMapInputBoundary addChatIdToMapInputBoundary;

    private final AddFeedIdInputBoundary addFeedIdInputBoundary;

    public UserController(AddUserInputBoundary addUserInputBoundary,
                          DeleteUserInputBoundary deleteUserInputBoundary,
                          GetUserFeedsInputBoundary getUserFeedsInputBoundary, GetUserObjectInputBoundary getUserObjectInputBoundary,
                          AddChatIdToMapInputBoundary addChatIdToMapInputBoundary, AddFeedIdInputBoundary addFeedIdInputBoundary
                          ) {
        this.addUserInputBoundary = addUserInputBoundary;
        this.deleteUserInputBoundary = deleteUserInputBoundary;
        this.getUserFeedsInputBoundary = getUserFeedsInputBoundary;
        this.getUserObjectInputBoundary = getUserObjectInputBoundary;
        this.addChatIdToMapInputBoundary = addChatIdToMapInputBoundary;
        this.addFeedIdInputBoundary = addFeedIdInputBoundary;
    }

    public void saveUser(String username, String password, String email, Map<Integer, Integer> mapOfChatToOtherUser, List<Integer> listOfFeedIds) throws IOException {
        UserRequestModel requestModel = new UserRequestModel(username, password, email, mapOfChatToOtherUser, listOfFeedIds, false);
        this.addUserInputBoundary.save(requestModel);
    }



}
