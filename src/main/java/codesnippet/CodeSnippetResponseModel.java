package codesnippet;

import java.time.LocalDateTime;

public class CodeSnippetResponseModel {

    private final int codeSnippetId;
    private final int userId;
    private String title;
    private String fileUrl;
    private final LocalDateTime creationTime;

    public CodeSnippetResponseModel(int codeSnippetId, String title, String fileUrl, int userId, LocalDateTime creationTime) {
        this.codeSnippetId = codeSnippetId;
        this.title = title;
        this.fileUrl = fileUrl;
        this.userId = userId;
        this.creationTime = creationTime;
    }

    public int getId() {
        return codeSnippetId;
    }

    public String getTitle() {
        return title;
    }

    public int getUserId() { return userId; }

    public String getFileUrl() { return fileUrl; }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
