package controller_presenter_gateway.codesnippet_controller_presenter_gateway;

import use_cases.codesnippet_use_cases.OpenCodeSnippetViewInputBoundary;

public class CodeSnippetViewController {

    private final OpenCodeSnippetViewInputBoundary openChatListInputBoundary;

    public CodeSnippetViewController(OpenCodeSnippetViewInputBoundary openChatListInputBoundary) {
        this.openChatListInputBoundary = openChatListInputBoundary;
    }

    public void openList(int userId) {
        this.openChatListInputBoundary.openList(userId);
    }
}
