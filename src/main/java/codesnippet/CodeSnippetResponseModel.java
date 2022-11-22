package codesnippet;

public class CodeSnippetResponseModel {
    private String title;
    private String fileUrl;
    private String creationTime;

    public CodeSnippetResponseModel(String title, String fileUrl, String creationTime) {
        this.title = title;
        this.fileUrl = fileUrl;
        this.creationTime = creationTime;
    }

    public String getTitle() {
        return title;
    }

    public String getCreationTime() {
        return creationTime;
    }
}
