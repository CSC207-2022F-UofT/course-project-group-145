package entities;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Entity representing a code snippet uploaded to the software as a user
 * Code snippets can be added, edited, and deleted by the user that created them
 * Code snippets can be added to feeds, and browsed by other users as part of a feed
 */
public class CodeSnippet implements Taggable{
    private int id;
    private int userId;
    private String title;
    private String fileUrl;
    private Date creationTime;
    private List<Tag> tags;
    private List<String> languages;
    private Boolean isDrafted;
    private Boolean isArchived;
    private Boolean isPublished;


    /**
     * Creates a new code snippet entity
     * @param id id of code snippet
     * @param userId id of user that uploaded the snippet
     * @param title title of the snippet
     * @param fileUrl URL of the snippet
     * @param creationTime time of creation of the snippet, as a date object
     */
    public CodeSnippet(int id, int userId, String title, String fileUrl, Date creationTime) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.fileUrl = fileUrl;
        this.creationTime = creationTime;
        this.tags = new ArrayList<Tag>();
        this.languages = new ArrayList<String>();
        this.isDrafted = true;
        this.isArchived = false;
        this.isPublished = false;
    }
    public int getId() { return id; }
    public String getTitle() {
        return this.title;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setTag(List<Tag> tags) {
      this.tags = tags;
    }
    
    public String getFileUrl() {
        return this.fileUrl;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }
    
    public void setLanguage(List<String> languages) {
        this.languages = languages;
    }

    public void publish() {
        this.isPublished = true;
    }

    public void archive() {
        this.isPublished = true;
    }

    /**
     * Method as part of the Taggable interface
     * Returns the number of tags that are the same between the snippet and the inputted tags
     * @param tags List of tags to compare this snippet to
     * @return number of tags that are the same between this snippet and the given list of tags
     */
    @Override
    public int similarity(List<Tag> tags) {
        int sim = 0;
        for (Tag tag: tags){
            sim += this.tags.contains(tag) ? 1: 0;
        }
        return sim;
    }

    @Override
    public List<Tag> getTags() {
        return this.tags;
    }
}
