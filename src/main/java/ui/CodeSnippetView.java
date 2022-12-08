package ui;

import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Java Swing UI that allows the user to view their code snippets
 */
public class CodeSnippetView extends JPanel implements CodeSnippetViewInterface, ActionListener {

    private int userId;

    private CodeSnippetViewController controller;

    /**
     * Initialises a new CodeSnippetViewUI
     */
    public CodeSnippetView(){
        JLabel title = new JLabel("Home");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton chatList = new JButton("View code snippets");
        JPanel chatListButton = new JPanel();
        chatListButton.add(chatList);
        JPanel logOutButton = new JPanel();
        chatList.addActionListener(this);
        chatList.setActionCommand("List");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(chatListButton);
        this.add(logOutButton);
    }

    /**
     * Method called by the elements of this UI whenever a user performs an action
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getActionCommand().equals("List")) {
            this.controller.openList(this.userId);
            this.setVisible(false);
        }
    }

    /**
     * Method called to open this UI
     * @param userId
     */
    @Override
    public void open(int userId) {
        this.userId = userId;
        this.setVisible(true);
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setController(CodeSnippetViewController controller) {
        this.controller = controller;
    }
}