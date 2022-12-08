package controller_presenter_gateway.feed_controller_presenter_gateway;

import java.util.List;

/**
 * Request model for saving a feed to the feed repository
 */
public class FeedGatewayRequestModel {


    private String feedID;
    private List<String> snippetIDs;
    private List<String> matchedIDs;
    private List<String> tags;
    private int curr;
    private int userId;

    /**
     * Create a new FeedGatewayRequestModel
     * @param snippetIDs List of IDs of snippets in feed
     * @param matchedIDs List of IDs of snippets matched in the feed
     * @param tags List of tags of the feed in string representation
     * @param curr current position on the feed
     * @param userId id of user who created feed
     * @param feedId id of feed
     */
    public FeedGatewayRequestModel(List<String> snippetIDs, List<String> matchedIDs, List<String> tags, int curr,
                                   int userId, String feedId){

        this.snippetIDs = snippetIDs;
        this.matchedIDs = matchedIDs;
        this.tags = tags;
        this.curr = curr;
        this.userId = userId;
        this.feedID = feedId;

    }

    public List<String> getMatchedIDs() {
        return matchedIDs;
    }

    public void setMatchedIDs(List<String> matchedIDs) {
        this.matchedIDs = matchedIDs;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getCurr() {
        return curr;
    }

    public void setCurr(int curr) {
        this.curr = curr;
    }

    public List<String> getSnippetIDs() {
        return snippetIDs;
    }

    public void setSnippetIDs(List<String> snippetIDs) {
        this.snippetIDs = snippetIDs;
    }

    public int getUserId(){return this.userId;}

    public void setUserId(int userId){this.userId = userId;}
    public String getFeedId() {
        return feedID;
    }
    public void setFeedId(String id){this.feedID = id;}
}
