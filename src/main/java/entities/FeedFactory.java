package entities;

import java.util.ArrayList;
import java.util.List;

public class FeedFactory {

    private TagFactory tagFactory;

    public Feed create(List<CodeSnippet> snippets, List<Tag> tags, int userId){
        return new Feed(snippets, tags, userId);
    }
    public Feed create(List<CodeSnippet> snippets, List<Tag> tags, List<CodeSnippet> matched, int userId){
        return new Feed(snippets, tags, matched, userId);
    }
}
