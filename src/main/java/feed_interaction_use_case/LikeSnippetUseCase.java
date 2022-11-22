package feed_interaction_use_case;

import entities.FeedFactory;
import feed.FeedDSRepository;

import java.util.ArrayList;
import java.util.List;

public class LikeSnippetUseCase implements LikeSnippetInputBoundary{
    final FeedDSRepository feedDSRepository;
    final FeedFactory feedFactory;

    final LikeSnippetOutputBoundary outputBoundary;

//    final CodeSnippetRepoGateway snippetRepoGateway;

    public LikeSnippetUseCase(FeedDSRepository feedDSRepository, FeedFactory feedFactory,
                              LikeSnippetOutputBoundary outputBoundary) {
        this.feedDSRepository = feedDSRepository;
        this.feedFactory = feedFactory;
        this.outputBoundary = outputBoundary;
//        this.snippetRepoGateway = snippetRepoGateway;
    }

    @Override
    public void like(String snippetID, LikeSnippetRequestModel likeSnippetRequestModel) {
        // obtain code snippets to create a list of CodeSnippet objects to them pass into the FeedFactory
        // obtain matched code snippets to create a list of matched CodeSnippets

//        List<CodeSnippetResponseModel> snippetsInFeed snippetRepoGateway.getCodeSnippets(likeSnippetRequestModel.getSnippetIDs());


        List<String> newMatched = new ArrayList<>(likeSnippetRequestModel.getMatchedIDs());
        newMatched.add(snippetID);
        // get list of matched code snippets
//        List<CodeSnippetResponseModel> matchedSnippets = snippetRepoGateway.getCodeSnippets(newMatched);

        // generate new feed
        // Feed newFeed = feedFactory.generateFeed()

        // from this new feed, I create a FeedGatewayRequestModel to sent this new feed to be saved in the repository.
        // feedDSRespository.save()

        // create a LikeSnippetResponseModel to be sent to the LikeSnippetOutputBoundary


    }
}
