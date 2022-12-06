package use_cases.codesnippet_use_cases;

import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetViewOutputBoundary;

public class OpenCodeSnippetView implements OpenCodeSnippetViewInputBoundary {

    private final CodeSnippetViewOutputBoundary codeSnippetOutputBoundary;

    public OpenCodeSnippetView(CodeSnippetViewOutputBoundary codeSnippetOutputBoundary) {
        this.codeSnippetOutputBoundary = codeSnippetOutputBoundary;
    }

    @Override
    public void openList(int userId) {
        codeSnippetOutputBoundary.openList(userId);
    }
}