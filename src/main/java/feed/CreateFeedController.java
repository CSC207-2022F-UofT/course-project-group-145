package feed;

import feed_use_case.CreateFeedUseCaseInputBoundary;

public class CreateFeedController implements FeedControllerInputBoundary{

    private CreateFeedUseCaseInputBoundary useCase;

    public CreateFeedController(CreateFeedUseCaseInputBoundary useCase){
        this.useCase = useCase;
    }

    /**
     *Calls the CreateFeedUseCase to create a new feed
     * @param model input model containing all the information needed to call the CreateFeedUseCase
     */
    @Override
    public void createNewFeed(FeedControllerInputModel model) {
        useCase.createFeed(model.getUserID(), model.getTags(), model.getLen());
    }
}
