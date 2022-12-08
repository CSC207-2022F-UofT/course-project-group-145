package controller_presenter_gateway.codesnippet_controller_presenter_gateway;

import ui.CodeSnippetListViewInterface;

import java.util.List;

/**
 * Presenter for CodeSnippet functions, updates CodeSnippetView
 */
public class CodeSnippetListPresenter implements CodeSnippetOutputBoundary {

    private final CodeSnippetListViewInterface codeSnippetViewInterface;

    private final CodeSnippetRepoGateway codeSnippetRepoGateway;

    /**
     * Constructor for CodeSnippetListPresenter
     * @param codeSnippetViewInterface Interface for the view that the presenter updates
     * @param codeSnippetRepoGateway gateway for the codeSnippetRepository
     */
    public CodeSnippetListPresenter(CodeSnippetListViewInterface codeSnippetViewInterface, CodeSnippetRepoGateway codeSnippetRepoGateway) {
        this.codeSnippetViewInterface = codeSnippetViewInterface;
        this.codeSnippetRepoGateway = codeSnippetRepoGateway;
    }

    /**
     * Updates view with the results of uploaded codesnippet
     * @param requestModel requestModel containing info about uploaded code snippet
     */
    @Override
    public void upload(CodeSnippetRequestModel requestModel) {
        codeSnippetViewInterface.upload(requestModel);
    }

    /**
     * updates view with info of deleted codeSnippet
     * @param codeSnippetId ID of deleted codesnippet
     */
    @Override
    public void delete(int codeSnippetId) {
        codeSnippetViewInterface.delete(codeSnippetId);
    }

    /**
     * Calls view to change codesnippet content
     * @param codeSnippetId id of code snippet
     * @param content contents of code snippets to change to
     */
    @Override
    public void edit(int codeSnippetId, CodeSnippetRequestModel content) {
        codeSnippetViewInterface.edit(codeSnippetId, content);
    }

    /**
     * Prepares error window in screen
     * @param message message to show to user
     */
    @Override
    public void failView(String message){
        codeSnippetViewInterface.failView(message);
    }

    /**
     * Prepares success message in view
     * @param message message to show user
     */
    @Override
    public void successView(String message) {
        codeSnippetViewInterface.successView(message);
    }

    /**
     * Updates the view with the list of code snippets from the user
     * @param userId ID of user to get codesnippets from
     */
    @Override
    public void list(int userId) {
        List<CodeSnippetResponseModel> codeSnippets = codeSnippetRepoGateway.getCodeSnippetsByUserId(userId);
        codeSnippetViewInterface.list(userId, codeSnippets);
    }
}
