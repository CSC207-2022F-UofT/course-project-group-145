package ui;

import codesnippet.CodeSnippetRequestModel;
import codesnippet.CodeSnippetResponseModel;
import codesnippet_controller.CodeSnippetListViewController;
import codesnippet_controller.CodeSnippetViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CodeSnippetDetailView extends JPanel implements CodeSnippetListViewInterface, ActionListener {

    private CodeSnippetListViewController controller;

    public CodeSnippetDetailView() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void upload(CodeSnippetRequestModel requestModel) {

    }

    @Override
    public void edit(int codeSnippetId, CodeSnippetRequestModel content) {

    }

    @Override
    public void delete(int codeSnippetId) {

    }

    @Override
    public void failView(String message) {

    }

    @Override
    public void successView(String message) {

    }

    @Override
    public void list(int userId, List<CodeSnippetResponseModel> codeSnippets) {

    }

    public void setController(CodeSnippetListViewController controller) {
        this.controller = controller;
    }
}
