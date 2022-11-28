package feed_interaction_use_case;

import java.io.IOException;

public interface LikeSnippetInputBoundary {
    void like(String snippetID, LikeSnippetRequestModel likeSnippetRequestModel) throws IOException;
}
