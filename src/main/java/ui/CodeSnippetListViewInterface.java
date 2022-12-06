package ui;

import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetRequestModel;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetResponseModel;

import java.util.List;

public interface CodeSnippetListViewInterface {
    void upload(CodeSnippetRequestModel requestModel);
    void edit(int codeSnippetId, CodeSnippetRequestModel content);
    void delete(int codeSnippetId);
    void failView(String message);
    void successView(String message);
    void list(int userId, List<CodeSnippetResponseModel> codeSnippets);
}
