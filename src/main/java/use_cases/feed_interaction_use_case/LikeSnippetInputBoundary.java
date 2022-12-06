package use_cases.feed_interaction_use_case;

import java.io.IOException;

public interface LikeSnippetInputBoundary {
    void like(LikeSnippetRequestModel likeSnippetRequestModel) throws IOException;
}
