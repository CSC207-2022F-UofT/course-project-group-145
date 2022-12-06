package controller_presenter_gateway.feed_controller_presenter_gateway;

public class CreateFeedResponseModel {
    private int userID;

    public CreateFeedResponseModel(int userID){
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }
}
