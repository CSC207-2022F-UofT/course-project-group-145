package feed_use_case;

import entities.*;
import feed.FeedDSRepository;
import feed.FeedGatewayRequestModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateFeedUseCase implements CreateFeedUseCaseInputBoundary{
    private FeedDSRepository FeedRepo;
    private TagFactory tagFactory;
    private FeedFactory feedFactory;

    @Override
    public void createFeed(List<String> tags, int size) {
        //Create tags from tags
        List<Tag> tagList = new ArrayList<>();
        for (String tag: tags){
            // tag object .equals can match to strings
            tagList.add(this.tagFactory.createTag(tag));
        }
        //TODO: Get snippets list from snippet repository
        List<CodeSnippet> allSnippets = new ArrayList<>();

        //TODO: Sort the snippets by tags
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
        FeedGatewayRequestModel model = new FeedGatewayRequestModel(snippetIDs, new ArrayList<String>(), tagStrings, 0);
    }

    @Override
    public void createFeed(List<String> tags) {
        createFeed(tags, 30);
    }
}
