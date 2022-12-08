package use_cases.feed_use_case;

import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetRepoGateway;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetResponseModel;
import controller_presenter_gateway.user_controller_presenter_gateway.UserRepoGateway;
import entities.*;
import controller_presenter_gateway.feed_controller_presenter_gateway.CreateFeedOutputBoundary;
import controller_presenter_gateway.feed_controller_presenter_gateway.CreateFeedResponseModel;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedDSRepository;
import controller_presenter_gateway.feed_controller_presenter_gateway.FeedGatewayRequestModel;

import java.io.IOException;
import java.util.*;

/**
 * Use case for creating a new feed
 */
public class CreateFeedUseCase implements CreateFeedUseCaseInputBoundary{
    private FeedDSRepository feedRepo;
    private CodeSnippetRepoGateway snippetRepo;
    private UserRepoGateway userRepo;
    private TagFactory tagFactory;
    private FeedFactory feedFactory;
    private CodeSnippetFactory snippetFactory;
    private CreateFeedOutputBoundary presenter;

    /**
     * Initialises a new CreateFeedUseCase
     * @param presenter presenter instance that implements CreateFeedOutputBoundary
     * @param feedRepo feed repository to save feed to persistent
     * @param snippetRepo snippet repository for retrieving snippets from persistent
     * @param userRepo user repository for adding feed to user
     * @param tagFactory instance of TagFactory for creating tags
     * @param feedFactory instance of FeedFactory for creating feeds
     * @param snippetFactory instance of SnippetFactory for creating CodeSnippets
     */
    public CreateFeedUseCase(CreateFeedOutputBoundary presenter, FeedDSRepository feedRepo, CodeSnippetRepoGateway snippetRepo, UserRepoGateway userRepo, TagFactory tagFactory, FeedFactory feedFactory, CodeSnippetFactory snippetFactory){
        this.presenter = presenter;
        this.feedRepo = feedRepo;
        this.snippetRepo = snippetRepo;
        this.userRepo = userRepo;
        this.tagFactory = tagFactory;
        this.feedFactory = feedFactory;
        this.snippetFactory = snippetFactory;
    }

    /**
     * Creates a new feed of the given size with snippets of the given tags, sorted from most relevant to the least relevant
     * Then assigns the newly created feed to the user specified
     * @param model the RequestModel for this use case, contains information about userID, tags, and length of feed to generate
     */
    @Override
    public void createFeed(CreateFeedUseCaseRequestModel model) {
        //Create tags objects from tags
        List<Tag> tagList = new ArrayList<>();
        for (String tag: model.getTags()){
            // tag object .equals can match to strings
            tagList.add(this.tagFactory.createTag(tag));
        }

        //Get snippets list from snippet repository and sort the snippets by tags
        Map<Integer, CodeSnippetResponseModel> allSnippetsRaw = snippetRepo.getAllCodeSnippets();
        List<CodeSnippet> allSnippets = new ArrayList<>();
        for(CodeSnippetResponseModel entry: allSnippetsRaw.values()){
            CodeSnippet snippet = snippetFactory.create(entry.getId(), entry.getUserId(), entry.getTitle(), entry.getFileUrl(), new Date());
            allSnippets.add(snippet);
        }
        allSnippets.sort(new TagComparator(tagList));
        int size = Math.min(model.getSize(), allSnippets.size());

        //Create a feed using feedFactory
        Feed feed = this.feedFactory.create(allSnippets.subList(0, size), tagList, model.getUserID());

        //Save feed to repository
        //Get Snippet IDs
        Iterator itr = feed.iterator();
        List<String> snippetIDs = new ArrayList<>();
        while(itr.hasNext()){
            CodeSnippet snippet = (CodeSnippet) itr.next();
            snippetIDs.add(String.valueOf(snippet.getId()));
        }
        //Get tags
        List<String> tagStrings = new ArrayList<>();
        for (Tag tag: feed.getTags()) {
            tagStrings.add(tag.toString());
        }
        int feedID = feedRepo.numFeeds();
        FeedGatewayRequestModel fgModel = new FeedGatewayRequestModel(snippetIDs, new ArrayList<String>(), tagStrings, 0, model.getUserID(), String.valueOf(feedID));
        try {
            //Save feed to feedRepo, and save user to userRepo
            feedRepo.save(fgModel);
            userRepo.addFeedId(model.getUserID(), feedID);
        }
        catch (IOException e){
            failView(e);
        }


        successView(model.getUserID());
    }


    private void successView(int userID){
        CreateFeedResponseModel model = new CreateFeedResponseModel(userID);
        presenter.successView(model);
    }
    private void failView(IOException e){
        presenter.failView(e.toString());
    }
}
