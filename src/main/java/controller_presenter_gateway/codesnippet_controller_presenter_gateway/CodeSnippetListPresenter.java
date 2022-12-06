package controller_presenter_gateway.codesnippet_controller_presenter_gateway;

import ui.CodeSnippetListViewInterface;

import java.util.List;

public class CodeSnippetListPresenter implements CodeSnippetOutputBoundary {

    private final CodeSnippetListViewInterface codeSnippetViewInterface;

    private final CodeSnippetRepoGateway codeSnippetRepoGateway;

    public CodeSnippetListPresenter(CodeSnippetListViewInterface codeSnippetViewInterface, CodeSnippetRepoGateway codeSnippetRepoGateway) {
        this.codeSnippetViewInterface = codeSnippetViewInterface;
        this.codeSnippetRepoGateway = codeSnippetRepoGateway;
    }

    @Override
    public void upload(CodeSnippetRequestModel requestModel) {
        codeSnippetViewInterface.upload(requestModel);
    }

    @Override
    public void delete(int codeSnippetId) {
        codeSnippetViewInterface.delete(codeSnippetId);
    }

    @Override
    public void edit(int codeSnippetId, CodeSnippetRequestModel content) {
        codeSnippetViewInterface.edit(codeSnippetId, content);
    }

    @Override
    public void failView(String message){
        codeSnippetViewInterface.failView(message);
    }

    @Override
    public void successView(String message) {
        codeSnippetViewInterface.successView(message);
    }

    @Override
    public void list(int userId) {
        List<CodeSnippetResponseModel> codeSnippets = codeSnippetRepoGateway.getCodeSnippetsByUserId(userId);
        codeSnippetViewInterface.list(userId, codeSnippets);
    }
}
