package ui;

import codesnippet.CodeSnippetRequestModel;
import codesnippet.CodeSnippetResponseModel;

import java.util.List;

public interface CodeSnippetListViewInterface {
    void upload(CodeSnippetRequestModel requestModel);
    void edit(int codeSnippetId, CodeSnippetRequestModel content);
    void delete(int codeSnippetId);
    void failView(String message);
    void successView(String message);
    void list(int userId, List<CodeSnippetResponseModel> codeSnippets);
}
