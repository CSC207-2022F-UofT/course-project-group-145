package codesnippet;

import java.time.LocalDateTime;

public class CodeSnippetRequestModel {
    private int codeSnippetId;
    private final int userId;
    private String title;
    private String fileUrl;
    private final LocalDateTime creationTime;

    public CodeSnippetRequestModel(String title, int userId, String fileUrl, LocalDateTime creationTime) {
        this.userId = userId;
        this.title = title;
        this.fileUrl = fileUrl;
        this.creationTime = creationTime;
    }

    int getCodeSnippetId() { return codeSnippetId; }
    int getUserId() {
        return userId;
    }
    String getTitle() {
        return title;
    }
    void setTitle(String title) {
        this.title = title;
    }
    String getFileUrl() {
        return fileUrl;
    }
    void setFileUrl(String fileUrl) {this.fileUrl = fileUrl; }
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
