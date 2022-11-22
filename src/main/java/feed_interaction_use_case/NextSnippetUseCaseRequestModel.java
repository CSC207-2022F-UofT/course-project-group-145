package feed_interaction_use_case;

import java.util.List;

public class NextSnippetUseCaseRequestModel {

    private List<String> snippetIDs;
    private List<String> matchedIDs;
    private List<String> tags;
    private int curr;

    public NextSnippetUseCaseRequestModel(List<String> snippetIDs, List<String> matchedIDs, List<String> tags, int curr){
        this.snippetIDs = snippetIDs;
        this.matchedIDs = matchedIDs;
        this.tags = tags;
        this.curr = curr;
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
}
