package codesnippet_use_cases;

import codesnippet_presenter.CodeSnippetViewOutputBoundary;

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