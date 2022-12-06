package ui;

import codesnippet_controller.CodeSnippetViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CodeSnippetView extends JPanel implements CodeSnippetViewInterface, ActionListener {

    private int userId;

    private CodeSnippetViewController controller;

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

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getActionCommand().equals("List")) {
            this.controller.openList(this.userId);
            this.setVisible(false);
        }
    }

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