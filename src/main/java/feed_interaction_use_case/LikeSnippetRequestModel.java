package feed_interaction_use_case;

public class LikeSnippetRequestModel {

    private String feedId;

    public LikeSnippetRequestModel(String feedId){
        this.feedId = feedId;
    }

    /**
     * This method returns the id of the feed represented by this request model.
     * @return the id of the feed represented by this request model.
     */
    public String getFeedId(){return this.feedId;}

    /**
     * This method sets the feed id of the request model.
     * @param feedId id of the feed that we wish to represent by this request model.
     */
    public void setFeedId(String feedId){this.feedId = feedId;}
}
