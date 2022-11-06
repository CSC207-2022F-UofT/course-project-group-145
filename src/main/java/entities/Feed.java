package entities;

import jdk.jshell.Snippet;

import java.util.Iterator;
import java.util.List;
import java.lang.Iterable;

public class Feed implements Iterable {
    //TODO: Add import for Snippets once that's done

    public static enum TAGS {
        Java, CSharp, Python
    }
    private String id;
    private List<TAGS> tags;
    private List<Snippet> snippets;
    private List<Snippet> matched;

    public Feed(List<Snippet> lst){
        this.snippets = lst;
    }

    public Feed(List<Snippet> snippets, List<Snippet> matched){
        this.matched = matched;
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
        public Snippet next() {
            return snippets.get(curr++);
        }

        public User match(){
            // TODO: make it actually return something
            // Adds current code snippet to matched, and returns the user of the snippet
            matched.add(snippets.get(curr));
            return null;
        }

        public User match(int i){
            // TODO: make it actually return something
            //Adds the code snippet at the ith index to matched, and returns the user of the snippet
            matched.add(snippets.get(i));
            return null;
        }
    }



}
