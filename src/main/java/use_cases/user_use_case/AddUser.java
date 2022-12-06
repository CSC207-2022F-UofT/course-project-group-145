package use_cases.user_use_case;

import controller_presenter_gateway.hompage_controller_presenter.HomePageOutputBoundary;
import controller_presenter_gateway.user_controller_presenter_gateway.UserOutputBoundary;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoRequestModel;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRequestModel;
import entities.User;
import entities.UserFactory;

import java.io.IOException;

public class AddUser implements AddUserInputBoundary {

    private final UserFactory userFactory;

    private final HomePageOutputBoundary homePageOutputBoundary;
    private final UserRepoGateway userRepoGateway;

    public AddUser(UserFactory userFactory, HomePageOutputBoundary homePageOutputBoundary,
                       UserRepoGateway userRepoGateway) {
        this.userFactory = userFactory;
        this.homePageOutputBoundary = homePageOutputBoundary;
        this.userRepoGateway = userRepoGateway;
    }

    /**
     * Creates a message that will be saved to
     * persistence by calling the gateway. It will then call the output boundary so UI will eventually update
     *
     */
    @Override
    public void save(UserRequestModel requestModel) throws IOException {
        UserRepoRequestModel userRepoRequestModel = getUserRepoRequestModel(requestModel);
        userRepoGateway.save(userRepoRequestModel);
        homePageOutputBoundary.openHome(userRepoRequestModel.getUserId());
    }

    /**
     * Creates a message that is a reply to another message that will be saved to the chat. It is then saved
     * to persistence by calling the gateway. It will then call the output boundary so UI will eventually update
     *
     * @param requestModel the request model created from controller with chat id and message
     */

    private UserRepoRequestModel getUserRepoRequestModel(UserRequestModel requestModel) {
        User.setNumUsers(userRepoGateway.getNumUsers());
        User user = userFactory.create(requestModel.getUsername(),
                requestModel.getPassword(), requestModel.getEmail(), requestModel.getListOfChatIds(), requestModel.getListOfFeedIds());
        return new UserRepoRequestModel(user.getUserId(),
                user.getUsername(), user.getPassword(), user.getEmail(), user.getListOfChatIds(),
                user.getListOfFeedIds(), user.isDeleted());
    }
}
