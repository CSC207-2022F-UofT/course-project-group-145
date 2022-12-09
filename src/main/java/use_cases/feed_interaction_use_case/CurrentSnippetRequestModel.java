package use_cases.feed_interaction_use_case;

/**
 * Request model for passing info to CurrentSnippetUseCase
 */
public class CurrentSnippetRequestModel {
    private String feedId;
    private int userID;

    /**
     * Creates a new CurrentSnippetRequestModel
     * @param feedId id of feed currently being examined
     */
    public CurrentSnippetRequestModel(int userID, String feedId){
        this.feedId = feedId;
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * This method returns the id of the feed.
     * @return id of the feed.
     */
    public String getFeedId(){
        return this.feedId;
    }

    /**
     * This method sets the id of the feed for which we wish to obtain the current snippet
     * @param feedId id of the feed for which we wish to obtain the current snippet
     */
    public void setFeedId(String feedId){
        this.feedId = feedId;
    }
}
