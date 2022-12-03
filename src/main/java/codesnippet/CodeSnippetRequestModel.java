package codesnippet;

import java.time.LocalDateTime;

public class CodeSnippetRequestModel {
    private final int codeSnippetId;
    private final int userId;
    private String title;
    private String fileUrl;
    private final LocalDateTime creationTime;

    public CodeSnippetRequestModel(int codeSnippetId, String title, int userId, String fileUrl, LocalDateTime creationTime) {
        this.codeSnippetId = codeSnippetId;
        this.userId = userId;
        this.title = title;
        this.fileUrl = fileUrl;
        this.creationTime = creationTime;
    }

    public int getId() { return codeSnippetId; }
    public int getUserId() {
        return userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getFileUrl() {
        return fileUrl;
    }
    public void setFileUrl(String fileUrl) {this.fileUrl = fileUrl; }
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
