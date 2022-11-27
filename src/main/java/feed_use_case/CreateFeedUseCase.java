package feed_use_case;

import entities.*;
import feed.FeedDSRepository;
import feed.FeedGatewayRequestModel;
import feed.CreateFeedOutputBoundary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateFeedUseCase implements CreateFeedUseCaseInputBoundary{
    private FeedDSRepository feedRepo;
    private TagFactory tagFactory;
    private FeedFactory feedFactory;

    private CreateFeedOutputBoundary presenter;

    public CreateFeedUseCase(CreateFeedOutputBoundary presenter, FeedDSRepository repo, TagFactory tagFactory, FeedFactory feedFactory){
        this.presenter = presenter;
        this.feedRepo = repo;
        this.tagFactory = tagFactory;
        this.feedFactory = feedFactory;
    }

    /**
     * Creates a new feed of the given size with snippets of the given tags, sorted from most relevant to the least relevant
     * Then assigns the newly created feed to the user specified
     * @param userID
     * @param tags
     * @param size
     */
    @Override
    public void createFeed(int userID, List<String> tags, int size) {
        //Create tags objects from tags
        List<Tag> tagList = new ArrayList<>();
        for (String tag: tags){
            // tag object .equals can match to strings
            tagList.add(this.tagFactory.createTag(tag));
        }

        //TODO: Get snippets list from snippet repository and sort the snippets by tags
        List<CodeSnippet> allSnippets = new ArrayList<>();
        allSnippets.sort(new TagComparator(tagList));

        //Create a feed using feedFactory
        Feed feed = this.feedFactory.create(allSnippets.subList(0, size), tagList);

        //Save feed to repository
        Iterator itr = feed.iterator();
        List<String> snippetIDs = new ArrayList<>();
        while(itr.hasNext()){
            // snippetIDs.add(itr.next())
            //TODO: add IDs to snippet object
        }
        List<String> tagStrings = new ArrayList<>();
        for (Tag tag: feed.getTags()) {
            tagStrings.add(tag.toString());
        }
        FeedGatewayRequestModel model = new FeedGatewayRequestModel(String.valueOf(feedRepo.numFeeds()), snippetIDs, new ArrayList<String>(), tagStrings, 0);
        try {
            feedRepo.save(model);
        }
        catch (IOException e){
            failView(e);
        }
        successView();
    }
    /**
     * Creates a new feed of size 30 with snippets of the given tags, sorted from most relevant to the least relevant
     *
     * @param tags
     */
    @Override
    public void createFeed(int userID, List<String> tags) {
        createFeed(userID, tags, 30);
    }

    private void successView(){
        presenter.successView();
    }
    private void failView(IOException e){
        presenter.failView(e.toString());
    }
}
