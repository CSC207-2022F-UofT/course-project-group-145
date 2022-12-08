package controller_presenter_gateway.feed_controller_presenter_gateway;

/**
 * Response model used to pass info to create feed presenter
 */
public class CreateFeedResponseModel {
    private int userID;

    /**
     * Creates a new CreateFeedResponseModel
     * @param userID id of user
     */
    public CreateFeedResponseModel(int userID){
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }
}
