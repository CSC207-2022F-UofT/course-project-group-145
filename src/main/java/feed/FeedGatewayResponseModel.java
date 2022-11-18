package feed;

import java.util.List;

public class FeedGatewayResponseModel {

    private List<String> snippetIDs;
    private List<String> matchedIDs;
    private List<String> tags;
    private int curr;

    public FeedGatewayResponseModel(List<String> snippetIDs, List<String> matchedIDs, List<String> tags, int curr){
        this.snippetIDs = snippetIDs;
        this.matchedIDs = matchedIDs;
        this.tags = tags;
        this.curr = curr;
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
}
