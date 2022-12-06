package codesnippet_presenter;

import codesnippet.CodeSnippetRequestModel;

public interface CodeSnippetOutputBoundary {

    void upload(CodeSnippetRequestModel requestModel);

    void delete(int codeSnippetId);

    void edit(int codeSnippetId, CodeSnippetRequestModel content);

    void failView(String message);

    void successView(String message);

    void list(int userId);
}
