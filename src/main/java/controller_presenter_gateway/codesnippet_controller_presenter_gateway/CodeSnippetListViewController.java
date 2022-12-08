package controller_presenter_gateway.codesnippet_controller_presenter_gateway;

import use_cases.codesnippet_use_cases.CodeSnippetListInputBoundary;

import java.util.Date;

/**
 * Controller for controlling code snippet use cases
 */
public class CodeSnippetListViewController {
    private final CodeSnippetListInputBoundary codeSnippetListInputBoundary;

    /**
     * Constructor for creating a new CodeSnippetListViewController
     * @param codeSnippetListInputBoundary CodeSnippet use case
     */
    public CodeSnippetListViewController(CodeSnippetListInputBoundary codeSnippetListInputBoundary) {
        this.codeSnippetListInputBoundary = codeSnippetListInputBoundary;
    }

    /**
     * Deletes code snippet
     * @param codeSnippetId id of snippet to be deleted
     */
    public void deleteCodeSnippet(int codeSnippetId) {
        this.codeSnippetListInputBoundary.delete(codeSnippetId);
    }

    /**
     * Edits code snippet
     * @param codeSnippetId id of snippet to be edited
     * @param content contents to change snippet content to
     */
    public void editCodeSnippet(int codeSnippetId, CodeSnippetResponseModel content) {
        this.codeSnippetListInputBoundary.edit(codeSnippetId, content);
    }

    /**
     * Uploads new code snippet
     * @param userId id of user to add snippet to
     * @param title title of the snippet
     * @param fileUrl fileurl of the uploaded code snippet
     */
    public void uploadCodeSnippet(int userId, String title, String fileUrl) {
        CodeSnippetRequestModel requestModel = new CodeSnippetRequestModel(userId, title, fileUrl, new Date());
        this.codeSnippetListInputBoundary.upload(requestModel);
    }

}
