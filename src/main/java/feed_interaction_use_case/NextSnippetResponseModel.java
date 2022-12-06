package feed_interaction_use_case;

public class NextSnippetResponseModel {
    private String feedId;
    public NextSnippetResponseModel(String feedId){
        this.feedId = feedId;
    }

    /**
     * This method returns the id of the next snippet in the feed. It is the snippet to be displayed next.
     * @return ID of the next snippet to be displayed.
     */
    public String getFeedId() {
        return feedId;
    }
}
