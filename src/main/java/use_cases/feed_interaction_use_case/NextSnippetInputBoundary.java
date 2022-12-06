package use_cases.feed_interaction_use_case;

import java.io.IOException;

public interface NextSnippetInputBoundary {
    void next(NextSnippetRequestModel nextSnippetRequestModel) throws IOException;
}
