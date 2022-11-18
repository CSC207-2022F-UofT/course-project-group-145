package entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.Iterable;

public class Feed implements Iterable{
    //TODO: Add import for Snippets once that's done

    private String id;
    private List<Tag> tags;
    private List<CodeSnippet> snippets;
    private List<CodeSnippet> matched;

    public Feed(List<CodeSnippet> lst, List<Tag> tags){
        this.snippets = lst;
        this.tags = tags;
        this.matched = new ArrayList<>();
    }

    public Feed(List<CodeSnippet> snippets, List<Tag> tags, List<CodeSnippet> matched){
        this.matched = matched;
        this.tags = tags;
        this.snippets = snippets;
    }

    protected void setSnippets(List<CodeSnippet> snippets){
        this.snippets = snippets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    @Override
    public FeedIterator iterator() {
        return new FeedIterator();
    }

    private class FeedIterator implements Iterator{
        private int curr;
        private FeedIterator(){
            this.curr = -1;
        }

        @Override
        public boolean hasNext() {
            return curr + 1 < snippets.size();
        }

        @Override
        public CodeSnippet next() {
            return snippets.get(curr++);
        }

        public int getCurr(){
            return curr;
        }
        public void setCurr(int curr){
            this.curr = curr;
        }

        public int match(){
            //Adds the code snippet at the ith index to matched, and returns the userID of the snippet
            matched.add(snippets.get(curr));
            return snippets.get(curr).getUserId();
        }
    }



}
