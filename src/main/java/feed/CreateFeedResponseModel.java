package feed;

public class CreateFeedResponseModel {
    private int userID;

    public CreateFeedResponseModel(int userID){
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }
}
