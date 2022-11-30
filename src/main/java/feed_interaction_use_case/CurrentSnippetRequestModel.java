package feed_interaction_use_case;

public class CurrentSnippetRequestModel {
    private String feedId;
    public CurrentSnippetRequestModel(String feedId){
        this.feedId = feedId;
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
