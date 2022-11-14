package entities;

import java.util.ArrayList;
import java.util.List;

public class FeedFactory {

    private TagFactory tagFactory;

    public Feed generateFeed(List<String> tags){
        // create tags from strings, then make feed
        List<Tag> tagList = new ArrayList<>();
        for (String tag: tags){
            // tag object .equals can match to strings
            tagList.add(tagFactory.createTag(tag));
        }

        Feed feed = new Feed(new ArrayList<Snippet>(), tagList);
        // Get list of codeSnippets TODO
        ArrayList<Snippet> rawSnippets = new ArrayList<Snippet>();
        //Sort by highest similarity score
        rawSnippets.sort(new TagComparator(tagList));
        //create feed with highest
        return null;
    }


}
