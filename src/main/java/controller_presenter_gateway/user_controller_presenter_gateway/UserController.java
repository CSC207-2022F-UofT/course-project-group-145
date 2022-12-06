package controller_presenter_gateway.user_controller_presenter_gateway;

import use_cases.user_use_case.AddUserInputBoundary;
import use_cases.user_use_case.DeleteUserInputBoundary;
import use_cases.user_use_case.GetUserFeedsInputBoundary;
import use_cases.user_use_case.GetUserObjectInputBoundary;
import use_cases.user_use_case.AddChatIdToMapInputBoundary;
import use_cases.user_use_case.AddFeedIdInputBoundary;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UserController {

    private final AddUserInputBoundary addUserInputBoundary;

//    private final DeleteUserInputBoundary deleteUserInputBoundary;
//
//    private final GetUserFeedsInputBoundary getUserFeedsInputBoundary;
//
//    private final GetUserObjectInputBoundary getUserObjectInputBoundary;
//
//    private final AddChatIdToMapInputBoundary addChatIdToMapInputBoundary;
//
//    private final AddFeedIdInputBoundary addFeedIdInputBoundary;

    public UserController(AddUserInputBoundary addUserInputBoundary
                          ) {
        this.addUserInputBoundary = addUserInputBoundary;
    }

    public void saveUser(String username, String password, String email, Map<Integer, Integer> mapOfChatToOtherUser, List<Integer> listOfFeedIds) throws IOException {
        UserRequestModel requestModel = new UserRequestModel(username, password, email, mapOfChatToOtherUser, listOfFeedIds, false);
        this.addUserInputBoundary.save(requestModel);
    }



}
