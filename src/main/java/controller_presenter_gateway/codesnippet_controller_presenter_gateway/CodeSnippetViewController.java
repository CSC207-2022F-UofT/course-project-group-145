package controller_presenter_gateway.codesnippet_controller_presenter_gateway;

import use_cases.codesnippet_use_cases.OpenCodeSnippetViewInputBoundary;

/**
 * Controller class for the detailed code snippet view, interacts with OpenCodeSnippetView use case
 */
public class CodeSnippetViewController {

    private final OpenCodeSnippetViewInputBoundary openChatListInputBoundary;

    /**
     * Creates a new CodeSnippetViewController
     * @param openChatListInputBoundary input boundary for the open code snippet view use case
     */
    public CodeSnippetViewController(OpenCodeSnippetViewInputBoundary openChatListInputBoundary) {
        this.openChatListInputBoundary = openChatListInputBoundary;
    }

    /**
     * opens code snippet view
     * @param userId id of user making request
     */
    public void openList(int userId) {
        this.openChatListInputBoundary.openList(userId);
    }
}
