package feed_interaction_use_case;

import java.util.List;

public class NextSnippetRequestModel {

    private String feedId;

    public NextSnippetRequestModel(String feedId){
        this.feedId = feedId;
    }

    /**
     * This method returns the feed id of the feed that we are passing into the use case. That is, the feed we want
     * to advance.
     * @return the feed id of the feed we wish to advance.
     */
    public String getFeedId(){return this.feedId;}

    /**
     * This method sets the id of the feed that we wish to advance to the request model.
     * @param feedId the id of the feed that we wish to advance.
     */
    public void setFeedId(String feedId){this.feedId = feedId;}

}
