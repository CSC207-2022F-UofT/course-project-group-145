package feed_interaction_use_case;

import java.util.List;

public class NextSnippetRequestModel {

    private String feedId;

    public NextSnippetRequestModel(String feedId){
        this.feedId = feedId;
    }

    public String getFeedId(){return this.feedId;}

    public void setFeedId(String feedId){this.feedId = feedId;}

}
