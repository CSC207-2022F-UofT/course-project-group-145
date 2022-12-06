package controller_presenter_gateway.feed_controller_presenter_gateway;

import use_cases.feed_use_case.CreateFeedUseCaseInputBoundary;
import use_cases.feed_use_case.CreateFeedUseCaseRequestModel;

/**
 * Controller that relays information from the feedview to the CreateFeedUseCase
 */
public class CreateFeedController implements FeedControllerInputBoundary{

    private CreateFeedUseCaseInputBoundary useCase;

    /**Constructor to create a CreateFeedController
     *
     * @param  useCase the input boundary interface of the CreateFeedUseCase
     */
    public CreateFeedController(CreateFeedUseCaseInputBoundary useCase){
        this.useCase = useCase;
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
}
