package entities;

import java.util.List;
import java.util.ArrayList;

public class CodeSnippet {
    private int userId;
    private String title;
    private String fileUrl;
    private String gistUrl;

    private List<String> tags;
    private List<String> languages;
    private Boolean isDrafted;
    private Boolean isArchived;
    private Boolean isPublished;


    CodeSnippet(int userId, String title, String fileUrl) {
        this.userId = userId;
        this.title = title;
        this.fileUrl = fileUrl;
        this.tags = new ArrayList<String>();
        this.languages = new ArrayList<String>();
        this.isDrafted = true;
        this.isArchived = false;
        this.isPublished = false;
    }

    public int getUserId() {
        return this.userId;
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
