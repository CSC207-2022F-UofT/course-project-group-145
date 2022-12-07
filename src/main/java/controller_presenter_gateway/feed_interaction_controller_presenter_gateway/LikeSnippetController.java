package controller_presenter_gateway.feed_interaction_controller_presenter_gateway;

import use_cases.feed_interaction_use_case.LikeSnippetInputBoundary;
import use_cases.feed_interaction_use_case.LikeSnippetRequestModel;

import java.io.IOException;

public class LikeSnippetController {
    final LikeSnippetInputBoundary inputBoundary;
    public LikeSnippetController(LikeSnippetInputBoundary inputBoundary){
        this.inputBoundary = inputBoundary;
    }

    /**
     * This method triggers a call to the use case via the interface that it implements. I first generate a request
     * model and then call the method in the interface with this request model so that I match the two users.
     * @param feedId the id of the feed in which i wish to generate a match.
     * @throws IOException this is thrown in case the feed does not exist.
     */
    public void like(String feedId) throws IOException {
        LikeSnippetRequestModel requestModel = new LikeSnippetRequestModel(feedId);
        inputBoundary.like(requestModel);
    }

}
