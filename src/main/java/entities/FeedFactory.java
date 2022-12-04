package entities;

import java.util.ArrayList;
import java.util.List;

public class FeedFactory {

    private TagFactory tagFactory;


    public Feed create(List<CodeSnippet> snippets, List<Tag> tags){
        return new Feed(snippets, tags);
    }
    public Feed create(List<CodeSnippet> snippets, List<Tag> tags, List<CodeSnippet> matched){
        return new Feed(snippets, tags, matched);
    }
}
