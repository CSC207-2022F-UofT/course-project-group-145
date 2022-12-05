package feed;

import java.util.List;

/**
 * Input model for FeedController for CreateFeedUseCase
 * contains info of the userID, as well as the tags to search for
 */
public class FeedControllerInputModel {
    private int userID;
    private List<String> tags;
    private int len;

    /**
     * Creates a new FeedControllerInputModel for calling use case using controllers that implement FeedControllerInputBoundary
     * @param userID ID of the user instance in the user repository
     * @param tags list of string representations of the tags to search for
     * @param len number of code snippets to include in newly generated feed
     */
    public FeedControllerInputModel(int userID, List<String> tags, int len){
        this.userID = userID;
        this.tags = tags;
        this.len = len;
    }
    /**
     * Creates a new FeedControllerInputModel for calling use case using controllers that implement FeedControllerInputBoundary
     * length of feed defaults to 30
     * @param userID ID of the user instance in the user repository
     * @param tags list of string representations of the tags to search for
     */
    public FeedControllerInputModel(int userID, List<String> tags){
        this.userID = userID;
        this.tags = tags;
        this.len = 30;
    }
    public int getUserID() {
        return userID;
    }

    public List<String> getTags() {
        return tags;
    }

    public int getLen(){
        return len;
    }
}
