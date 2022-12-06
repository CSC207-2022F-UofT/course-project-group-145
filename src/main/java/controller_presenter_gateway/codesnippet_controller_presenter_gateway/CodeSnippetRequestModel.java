package controller_presenter_gateway.codesnippet_controller_presenter_gateway;

import java.util.Date;

public class CodeSnippetRequestModel {
    private final int userId;
    private String title;
    private String fileUrl;
    private Date creationTime;

    public CodeSnippetRequestModel(int userId, String title, String fileUrl, Date creationTime) {
        this.userId = userId;
        this.title = title;
        this.fileUrl = fileUrl;
        this.creationTime = creationTime;
    }

    public int getUserId() {
        return userId;
    }
    public String getTitle() {
        return title;
    }
    public String getFileUrl() {
        return fileUrl;
    }
    public Date getCreationTime() {
        return creationTime;
    }
}
