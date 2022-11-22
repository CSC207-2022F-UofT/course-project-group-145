package feed_interaction_use_case;

import entities.Feed;
import entities.FeedFactory;
import feed.FeedDSRepository;

import java.util.ArrayList;
import java.util.List;

public class LikeSnippetUseCase implements LikeSnippetInputBoundary{
    final FeedDSRepository feedDSRepository;
    final FeedFactory feedFactory;

    public LikeSnippetUseCase(FeedDSRepository feedDSRepository, FeedFactory feedFactory) {
        this.feedDSRepository = feedDSRepository;
        this.feedFactory = feedFactory;
    }

    @Override
    public void like(String snippetID, LikeSnippetUseCaseRequestModel likeSnippetUseCaseRequestModel) {
        // obtain code snippets to create a list of CodeSnippet objects to them pass into the FeedFactory
        // obtain matched code snippets to create a list of matched CodeSnippets

        List<String> newMatched = new ArrayList<>(likeSnippetUseCaseRequestModel.getMatchedIDs());
        newMatched.add(snippetID);

        // Feed newFeed = feedFactory.generateFeed()

        // from this new feed, I create a FeedGatewayRequestModel to sent this new feed to be saved in the repository.
        // feedDSRespository.save()

    }
}
