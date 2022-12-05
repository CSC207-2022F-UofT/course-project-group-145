package feed_use_case;

import codesnippet.CodeSnippetRepoGateway;
import codesnippet.CodeSnippetRequestModel;
import codesnippet.CodeSnippetResponseModel;
import entities.*;
import feed.CreateFeedOutputBoundary;
import feed.CreateFeedResponseModel;
import feed.FeedDSRepository;
import feed.FeedGatewayRequestModel;
import user.UserRepoGateway;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

public class CreateFeedUseCase implements CreateFeedUseCaseInputBoundary{
    private FeedDSRepository feedRepo;
    private CodeSnippetRepoGateway snippetRepo;
    private UserRepoGateway userRepo;
    private TagFactory tagFactory;
    private FeedFactory feedFactory;
    private CodeSnippetFactory snippetFactory;
    private CreateFeedOutputBoundary presenter;

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
        Map<Integer, CodeSnippetRequestModel> allSnippetsRaw = snippetRepo.getAllCodeSnippets();
        List<CodeSnippet> allSnippets = new ArrayList<>();
        for(CodeSnippetRequestModel entry: allSnippetsRaw.values()){
            CodeSnippet snippet = snippetFactory.create(entry.getId(), entry.getUserId(), entry.getTitle(), entry.getFileUrl());
            allSnippets.add(snippet);
        }
        allSnippets.sort(new TagComparator(tagList));

        //Create a feed using feedFactory
        Feed feed = this.feedFactory.create(allSnippets.subList(0, model.getSize()), tagList);

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
        FeedGatewayRequestModel fgModel = new FeedGatewayRequestModel(String.valueOf(feedID), snippetIDs, new ArrayList<String>(), tagStrings, 0);
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
