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

/**
 * Controller that relays information between the register screen and the create user use case
 */
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

    /**
     * Makes a new UserController
     * @param addUserInputBoundary instance of the create user use case
     */
    public UserController(AddUserInputBoundary addUserInputBoundary) {
        this.addUserInputBoundary = addUserInputBoundary;
    }

    /**
     * Creates and saves a new user
     * @param username username of user
     * @param password password of user
     * @param email email of user
     * @param mapOfChatToOtherUser map containing ids of chats this user owns, mapped to the id of user the chat is with
     * @param listOfFeedIds list of ids of feeds this user owns
     * @throws IOException
     */
    public void saveUser(String username, String password, String email, Map<Integer, Integer> mapOfChatToOtherUser, List<Integer> listOfFeedIds) throws IOException {
        UserRequestModel requestModel = new UserRequestModel(username, password, email, mapOfChatToOtherUser, listOfFeedIds, false);
        this.addUserInputBoundary.save(requestModel);
    }



}
