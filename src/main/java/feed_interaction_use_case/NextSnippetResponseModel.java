package feed_interaction_use_case;

public class NextSnippetResponseModel {
    private String nextSnippetId;
    public NextSnippetResponseModel(String nextSnippetId){
        this.nextSnippetId = nextSnippetId;
    }

    /**
     * This method returns the id of the next snippet in the feed. It is the snippet to be displayed next.
     * @return ID of the next snippet to be displayed.
     */
    public String getNextSnippetId() {
        return nextSnippetId;
    }
}
