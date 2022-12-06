package use_cases.feed_interaction_use_case;

import java.io.IOException;

public interface CurrentSnippetInputBoundary {
    public void current(CurrentSnippetRequestModel currentSnippetRequestModel) throws IOException;
}
