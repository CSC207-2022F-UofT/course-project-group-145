package feed_interaction_use_case;

public class CurrentSnippetResponseModel {
    private final String feedId;
    public CurrentSnippetResponseModel(String feedId){
        this.feedId = feedId;
    }

    /**
     * This method returns the snippet id of the current snippet in the feed.
     * @return id of the current snippet in the feed.
     */
    public String getFeedId(){
        return this.feedId;
    }
}
