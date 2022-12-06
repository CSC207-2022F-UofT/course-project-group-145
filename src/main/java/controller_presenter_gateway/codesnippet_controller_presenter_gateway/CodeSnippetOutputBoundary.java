package controller_presenter_gateway.codesnippet_controller_presenter_gateway;

public interface CodeSnippetOutputBoundary {

    void upload(CodeSnippetRequestModel requestModel);

    void delete(int codeSnippetId);

    void edit(int codeSnippetId, CodeSnippetRequestModel content);

    void failView(String message);

    void successView(String message);

    void list(int userId);
}
