package controller_presenter_gateway.feed_interaction_controller_presenter_gateway;

import use_cases.feed_interaction_use_case.CurrentSnippetInputBoundary;
import use_cases.feed_interaction_use_case.CurrentSnippetRequestModel;

import java.io.IOException;

/**
 * Controller that controls the current snippet use case
 */
public class CurrentSnippetController {
    final CurrentSnippetInputBoundary inputBoundary;

    /**
     * Creates a new CurrentSnippetController
     * @param inputBoundary input boundary of the Current snippet use case
     */
    public CurrentSnippetController(CurrentSnippetInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * This method makes a call to the use case via the interface that it implements. It gets the current snippet in the
     * feed with id 'id'. To do this, I first create a request model, and then I make a call to the method in the
     * interface.
     * @param id id of the feed for which we wish to obtain the current snippet.
     * @throws IOException this is thrown in case there does not exist a feed with such id.
     */
    public void getCurrent(String id) throws IOException {
        CurrentSnippetRequestModel requestModel = new CurrentSnippetRequestModel(id);
        inputBoundary.current(requestModel);
    }
}
