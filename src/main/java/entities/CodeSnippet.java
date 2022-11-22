package entities;

import java.util.List;
import java.util.ArrayList;

public class CodeSnippet {
    private int id;
    private int userId;
    private String title;
    private String fileUrl;
    private String gistUrl;
    private List<String> tags;
    private List<String> languages;
    private Boolean isDrafted;
    private Boolean isArchived;
    private Boolean isPublished;


    CodeSnippet(int id, int userId, String title, String fileUrl) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.fileUrl = fileUrl;
        this.tags = new ArrayList<String>();
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
}
