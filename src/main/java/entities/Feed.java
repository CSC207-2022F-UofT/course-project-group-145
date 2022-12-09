package entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.Iterable;

/**
 * Feed entity containing a sorted list of code snippets based on some list of given keyword tags
 * Feeds allow for users to browse code snippets made by others
 */
public class Feed implements Iterable{
    private int userID;
    private String id;
    private List<Tag> tags;
    private List<CodeSnippet> snippets;
    private List<CodeSnippet> matched;

    private int userId;

    /**
     * Creates a new feed object
     * @param lst list of code snippets to be assigned to this feed
     * @param tags list of tags to be assigned to this feed
     * @param userId id of user creating this feed
     */
    public Feed(List<CodeSnippet> lst, List<Tag> tags, int userId){
        this.snippets = lst;
        this.tags = tags;
        this.matched = new ArrayList<>();
        this.userId = userId;
    }

    /**
     * Creates a new feed object, but with snippets already in the matched list
     * @param snippets list of code snippets to be assigned to this feed
     * @param matched list of code snippets to be assigned to the matched list of this feed
     * @param tags list of tags to be assigned to this feed
     * @param userId id of user creating this feed
     */
    public Feed(List<CodeSnippet> snippets, List<Tag> tags, List<CodeSnippet> matched, int userId){
        this.matched = matched;
        this.tags = tags;
        this.snippets = snippets;
        this.userId = userId;
    }

    public List<Tag> getTags() {
        return tags;
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


    public int getUserId(){return this.userId;}

    public void setUserId(int userId){this.userId = userId;}

    /**
     * Constructor for returning an iterator object for this feed
     * @return an instance of FeedIterator for iterating through this feed
     */
    @Override
    public FeedIterator iterator() {
        return new FeedIterator();
    }

    /**
     * Iterator for iterating through a feed object
     */
    private class FeedIterator implements Iterator{
        private int curr;
        private FeedIterator(){
            this.curr = 0;
        }

        /**
         * Method for checking if the iterator has reached the end of the feed or not
         * @return boolean representing if there are still snippets left in the feed to iterate through
         */
        @Override
        public boolean hasNext() {
            return curr < snippets.size();
        }

        /**
         * Returns the next snippet in the feed
         * @return the next CodeSnippet in the feed
         */
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

        /**
         * Adds the current code snippet to the matched list
         * @return returns the user ID of the owner of the snippet that was matched
         */
        public int match(){
            //Adds the code snippet at the ith index to matched, and returns the userID of the snippet
            matched.add(snippets.get(curr));
            return snippets.get(curr).getUserId();
        }
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
