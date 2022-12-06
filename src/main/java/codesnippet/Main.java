package codesnippet;

import codesnippet_controller.CodeSnippetViewController;
import codesnippet_presenter.CodeSnippetPresenter;
import codesnippet_presenter.CodeSnippetViewOutputBoundary;
import codesnippet_use_cases.OpenCodeSnippetView;
import codesnippet_use_cases.OpenCodeSnippetViewInputBoundary;
import ui.CodeSnippetView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        CodeSnippetRepository repo = new CodeSnippetRepository("code-snippet.json");

        repo.save(new CodeSnippetResponseModel(0, 0, "New Code Snippet", "/usr", new Date()));

        JFrame application = new JFrame("Code Snippet Management");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(600, 600);
        application.setPreferredSize(new Dimension(600, 600));
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        CodeSnippetView codeSnippetView = new CodeSnippetView();
        CodeSnippetViewOutputBoundary codeSnippetPresenter = new CodeSnippetPresenter(codeSnippetView);
        OpenCodeSnippetViewInputBoundary openCodeSnippet = new OpenCodeSnippetView(codeSnippetPresenter);
        CodeSnippetViewController codeSnippetViewController = new CodeSnippetViewController(openCodeSnippet);
        codeSnippetView.setController(codeSnippetViewController);

        screens.add(codeSnippetView, "Code Snippet Management");
        cardLayout.show(screens, "Code Snippet Management");
        application.pack();
        application.setVisible(true);
    }
}
