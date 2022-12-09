package controller_presenter_gateway.feed_controller_presenter_gateway;

import use_cases.feed_interaction_use_case.CurrentSnippetInputBoundary;
import use_cases.feed_interaction_use_case.CurrentSnippetRequestModel;
import use_cases.feed_use_case.CreateFeedUseCaseInputBoundary;
import use_cases.feed_use_case.CreateFeedUseCaseRequestModel;
import use_cases.homepage_use_cases.OpenHomePageInputBoundary;

import java.io.IOException;

/**
 * Controller that relays information from the feedview to the CreateFeedUseCase
 */
public class CreateFeedController implements FeedControllerInputBoundary{

    private CreateFeedUseCaseInputBoundary useCase;
    private OpenHomePageInputBoundary openHome;
    private CurrentSnippetInputBoundary currentSnippetUseCase;

    /**Constructor to create a CreateFeedController
     *
     * @param  useCase the input boundary interface of the CreateFeedUseCase
     */
    public CreateFeedController(CreateFeedUseCaseInputBoundary useCase, OpenHomePageInputBoundary openHome, CurrentSnippetInputBoundary currentSnippetUseCase){
        this.useCase = useCase;
        this.openHome = openHome;
        this.currentSnippetUseCase = currentSnippetUseCase;
    }

    /**
     *Calls the CreateFeedUseCase to create a new feed
     * @param model input model containing all the information needed to call the CreateFeedUseCase
     */
    @Override
    public void createNewFeed(FeedControllerInputModel model) {
        CreateFeedUseCaseRequestModel rModel = new CreateFeedUseCaseRequestModel(model.getUserID(), model.getTags(), model.getLen());
        useCase.createFeed(rModel);
    }
    @Override
    public void goBack(int userID){
        openHome.openHome(userID);
    }
    @Override
    public void openDetail(int userID, int feedID) throws IOException {
        this.currentSnippetUseCase.current(new CurrentSnippetRequestModel(feedID, String.valueOf(feedID)));
    }
}
