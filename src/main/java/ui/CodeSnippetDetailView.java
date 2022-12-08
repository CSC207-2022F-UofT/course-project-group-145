package ui;

import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetRequestModel;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetResponseModel;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetListViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Java swing UI that shows the details of a code snippet to a user
 * Allows user to upload, edit, and delete code snippets
 */
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
