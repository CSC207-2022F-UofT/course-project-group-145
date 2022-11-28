package feed_interaction_use_case;

public class NextSnippetResponseModel {
    private String nextSnippetId;
    public NextSnippetResponseModel(String nextSnippetId){
        this.nextSnippetId = nextSnippetId;
    }

    public String getNextSnippetId() {
        return nextSnippetId;
    }
}
