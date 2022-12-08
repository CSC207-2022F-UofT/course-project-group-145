package controller_presenter_gateway.feed_controller_presenter_gateway;

import java.util.List;

/**
 * Response model for feed repository to pass back information about feed
 */
public class FeedGatewayResponseModel {

    private List<String> snippetIDs;
    private List<String> matchedIDs;
    private List<String> tags;
    private int curr;

    private int userId;

    /**
     * Creates a new FeedGatewayResponseModel
     * @param snippetIDs id of snippets in the feed
     * @param matchedIDs id of snippets user chose to match in the feed
     * @param tags list of tags in feed in string form
     * @param curr current snippet in feed
     * @param userId id of user who made feed
     */
    public FeedGatewayResponseModel(List<String> snippetIDs, List<String> matchedIDs, List<String> tags, int curr,
                                    int userId){

        this.snippetIDs = snippetIDs;
        this.matchedIDs = matchedIDs;
        this.tags = tags;
        this.curr = curr;
        this.userId = userId;

    }

    public List<String> getMatchedIDs() {
        return matchedIDs;
    }

    public List<String> getTags() {
        return tags;
    }

    public int getCurr() {
        return curr;
    }

    public List<String> getSnippetIDs() {
        return snippetIDs;
    }

    public int getUserId(){return this.userId;}
}
