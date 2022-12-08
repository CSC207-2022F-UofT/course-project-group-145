package controller_presenter_gateway.feed_interaction_controller_presenter_gateway;

/**
 * Response model used to return information to the NextSnippetPresenter
 */
public class NextSnippetResponseModel {
    private String feedId;

    /**
     * Creates a new NextSnippetResponseModel
     * @param feedId id of current feed
     */
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
