package controller_presenter_gateway.codesnippet_controller_presenter_gateway;

import use_cases.codesnippet_use_cases.CodeSnippetListInputBoundary;

import java.util.Date;

public class CodeSnippetListViewController {
    private final CodeSnippetListInputBoundary codeSnippetListInputBoundary;

    public CodeSnippetListViewController(CodeSnippetListInputBoundary codeSnippetListInputBoundary) {
        this.codeSnippetListInputBoundary = codeSnippetListInputBoundary;
    }

    public void deleteCodeSnippet(int codeSnippetId) {
        this.codeSnippetListInputBoundary.delete(codeSnippetId);
    }

    public void editCodeSnippet(int codeSnippetId, CodeSnippetResponseModel content) {
        this.codeSnippetListInputBoundary.edit(codeSnippetId, content);
    }

    public void uploadCodeSnippet(int userId, String title, String fileUrl) {
        CodeSnippetRequestModel requestModel = new CodeSnippetRequestModel(userId, title, fileUrl, new Date());
        this.codeSnippetListInputBoundary.upload(requestModel);
    }

}
