package controller_presenter_gateway.codesnippet_controller_presenter_gateway;

import java.util.Date;

public class CodeSnippetResponseModel {
    private final int codeSnippetId;
    private final int userId;
    private String title;
    private String fileUrl;
    private Date creationTime;

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
