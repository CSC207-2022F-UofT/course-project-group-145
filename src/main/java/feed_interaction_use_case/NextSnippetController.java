package feed_interaction_use_case;

import java.io.IOException;

public class NextSnippetController {
    final NextSnippetInputBoundary inputBoundary;

    public NextSnippetController(NextSnippetInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    void next(String id) throws IOException {
        NextSnippetRequestModel requestModel = new NextSnippetRequestModel(id);
        inputBoundary.next(requestModel);
    }
}
