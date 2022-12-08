package controller_presenter_gateway.codesnippet_controller_presenter_gateway;

import java.util.Date;

/**
 * Response model for CodeSnippetListInteracter use case
 */
public class CodeSnippetResponseModel {
    private final int codeSnippetId;
    private final int userId;
    private String title;
    private String fileUrl;
    private Date creationTime;

    /**
     * Creates a new CodeSnippetResponseModel
     * @param codeSnippetId id of code snippet
     * @param userId id of user uploading snippet
     * @param title title of snippet
     * @param fileUrl url of snippet being uploaded (or the path)
     * @param creationTime creation time of snippet
     */
    public CodeSnippetResponseModel(int codeSnippetId, int userId, String title, String fileUrl, Date creationTime) {
        this.codeSnippetId = codeSnippetId;
        this.userId = userId;
        this.title = title;
        this.fileUrl = fileUrl;
        this.creationTime = creationTime;
    }

    public int getId() {
        return codeSnippetId;
    }
    public int getUserId() { return userId; }
    public String getTitle() { return title; }
    public String getFileUrl() { return fileUrl; }
    public Date getCreationTime() {
        return creationTime;
    }
    public void setIsDeleted() {

    }
}
