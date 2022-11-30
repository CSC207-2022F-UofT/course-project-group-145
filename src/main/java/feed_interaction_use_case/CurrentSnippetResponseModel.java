package feed_interaction_use_case;

public class CurrentSnippetResponseModel {
    private final String snippetId;
    public CurrentSnippetResponseModel(String snippetId){
        this.snippetId = snippetId;
    }

    /**
     * This method returns the snippet id of the current snippet in the feed.
     * @return id of the current snippet in the feed.
     */
    public String getSnippetId(){
        return this.snippetId;
    }
}
