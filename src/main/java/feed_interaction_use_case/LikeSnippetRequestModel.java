package feed_interaction_use_case;

import java.util.List;

public class LikeSnippetRequestModel {

    private String feedId;

    public LikeSnippetRequestModel(String feedId){
        this.feedId = feedId;
    }

    public String getFeedId(){return this.feedId;}

    public void setFeedId(String feedId){this.feedId = feedId;}
}
