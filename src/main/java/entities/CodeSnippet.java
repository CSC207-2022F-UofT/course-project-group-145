package entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class CodeSnippet {
    private int id;
    private int userId;
    private String title;
    private String fileUrl;
    private LocalDateTime creationTime;
    private List<String> tags;
    private List<String> languages;
    private Boolean isDrafted;
    private Boolean isArchived;
    private Boolean isPublished;


    public CodeSnippet(int id, int userId, String title, String fileUrl) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.fileUrl = fileUrl;
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

    public String getFileUrl() {
        return this.fileUrl;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }


    public void setTag(List<String> tags) {
        this.tags = tags;
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
