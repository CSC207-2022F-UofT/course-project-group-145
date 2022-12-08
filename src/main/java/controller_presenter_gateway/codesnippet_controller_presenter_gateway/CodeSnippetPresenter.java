package controller_presenter_gateway.codesnippet_controller_presenter_gateway;

import ui.CodeSnippetViewInterface;

/**
 * Presenter that updates the detailed code snippet view CodeSnippetDetailView
 */
public class CodeSnippetPresenter implements CodeSnippetViewOutputBoundary {
        private final CodeSnippetViewInterface codeSnippetViewInterface;

    /**
     * Creates a new CodeSnippetPresenter
     * @param codeSnippetViewInterface interface of the view to update
     */
    public CodeSnippetPresenter(CodeSnippetViewInterface codeSnippetViewInterface) {
            this.codeSnippetViewInterface = codeSnippetViewInterface;
    }

    /**
     * Returns back to the list view of codesnippets
     * @param userId id of the user
     */
    @Override
    public void openList(int userId) {
            this.codeSnippetViewInterface.open(userId);
        }
}
