package feed_interaction_use_case;

import entities.FeedFactory;
import feed.FeedDSRepository;

public class NextSnippetUseCase implements NextSnippetInputBoundary{
    final FeedDSRepository feedDSRepository;
    final FeedFactory feedFactory;

    public NextSnippetUseCase(FeedDSRepository feedDSRepository, FeedFactory feedFactory) {
        this.feedDSRepository = feedDSRepository;
        this.feedFactory = feedFactory;
    }

    @Override
    public void next(NextSnippetUseCaseRequestModel nextSnippetUseCaseRequestModel){
        // create a new FeedGatewayRequestModel with info from nextSnippetUseCaseRequestModel
        // save this new object into the repository
        // feedDSRepository.save()
    }
}
