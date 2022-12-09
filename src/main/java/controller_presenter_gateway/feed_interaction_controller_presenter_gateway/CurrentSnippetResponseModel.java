package controller_presenter_gateway.feed_interaction_controller_presenter_gateway;

/**
 * Response model that is sent to the CurrentSnippetPresenter
 */
public class CurrentSnippetResponseModel {
    private final String feedId;
    private int userID;

    /**
     * Create a new CurrentSnippetResponseModel
     * @param feedId id of the current feeds
     */
    public CurrentSnippetResponseModel(int userID, String feedId){
        this.feedId = feedId;
        this.userID = userID;
    }

    /**
     * This method returns the snippet id of the current snippet in the feed.
     * @return id of the current snippet in the feed.
     */
    public String getFeedId(){
        return this.feedId;
    }
    public int getUserID(){
        return this.userID;
    }
}
