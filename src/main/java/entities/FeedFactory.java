package entities;

import java.util.ArrayList;
import java.util.List;

public class FeedFactory {

    private TagFactory tagFactory;

    public Feed generateFeed(List<String> tags, int length){
        // create tags from strings, then make feed
        List<Tag> tagList = new ArrayList<>();
        for (String tag: tags){
            // tag object .equals can match to strings
            tagList.add(this.tagFactory.createTag(tag));
        }

        // Feed feed = new Feed(new ArrayList<>(), tagList);
        // Get list of codeSnippets TODO
        ArrayList<CodeSnippet> rawSnippets = new ArrayList<CodeSnippet>();
        //Sort by highest similarity score
        rawSnippets.sort(new TagComparator(tagList));
        //create feed with highest
        // feed.setSnippets(rawSnippets.subList(0, length));
        return null;
    }
}
