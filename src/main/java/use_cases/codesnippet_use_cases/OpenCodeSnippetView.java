package use_cases.codesnippet_use_cases;

import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetViewOutputBoundary;

/**
 * Use case for opening the detailed view of code snippets
 */
public class OpenCodeSnippetView implements OpenCodeSnippetViewInputBoundary {

    private final CodeSnippetViewOutputBoundary codeSnippetOutputBoundary;

    /**
     * constructor for creating a new OpenCodeSnippetView use case
     * @param codeSnippetOutputBoundary presenter to be updated
     */
    public OpenCodeSnippetView(CodeSnippetViewOutputBoundary codeSnippetOutputBoundary) {
        this.codeSnippetOutputBoundary = codeSnippetOutputBoundary;
    }

    /**
     * Call to open the list of code snippets for user specified
     * @param userId id of user to look at code snippets
     */
    @Override
    public void openList(int userId) {
        codeSnippetOutputBoundary.openList(userId);
    }
}