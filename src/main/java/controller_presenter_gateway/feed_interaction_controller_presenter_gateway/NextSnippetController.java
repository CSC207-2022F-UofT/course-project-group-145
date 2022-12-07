package controller_presenter_gateway.feed_interaction_controller_presenter_gateway;

import use_cases.feed_interaction_use_case.NextSnippetInputBoundary;
import use_cases.feed_interaction_use_case.NextSnippetRequestModel;

import java.io.IOException;

public class NextSnippetController {
    final NextSnippetInputBoundary inputBoundary;

    public NextSnippetController(NextSnippetInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    /**
     * This method triggers a call to the use case so that we advance the feed with this id. We do this by calling
     * the input boundary of the use case, passing in a request model generated from id.
     * @param id the id of the feed that we wish to advance. This will be used to generate a request model.
     * @throws IOException this exception is thrown in case there does not exist a feed with this id
     */
    public void next(String id) throws IOException {
        NextSnippetRequestModel requestModel = new NextSnippetRequestModel(id);
        inputBoundary.next(requestModel);
    }
}
