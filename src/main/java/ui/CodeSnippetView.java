package ui;

import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetListViewController;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CodeSnippetView extends JPanel implements CodeSnippetViewInterface, ActionListener {

    private int userId;

    private JButton uploadButton;
    private JFileChooser fc;

    private CodeSnippetViewController viewController;
    private CodeSnippetListViewController listController;

    public CodeSnippetView(){
        JLabel title = new JLabel("Code Snippet Main");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton chatList = new JButton("View code snippets");
        JPanel chatListButton = new JPanel();
        chatListButton.add(chatList);
        JPanel logOutButton = new JPanel();
        chatList.addActionListener(this);
        chatList.setActionCommand("List");

        this.uploadButton = new JButton("Upload Code Snippet");
        this.uploadButton.addActionListener(this);
        this.uploadButton.setBounds(100, 100, 100, 100);
        this.add(uploadButton);
        this.fc = new JFileChooser();


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(chatListButton);
        this.add(logOutButton);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
//        if(evt.getActionCommand().equals("List")) {
//            this.controller.openList(this.userId);
//            this.setVisible(false);
//        }
        if (evt.getSource().equals(uploadButton)){
            File file = fc.getSelectedFile();
            this.listController.uploadCodeSnippet(userId, file.getName(), file.getPath());
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
        this.viewController = controller;
    }

    public static void main(String[] args){
        JFrame application = new JFrame("CodeR");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(600, 600);
        application.setPreferredSize(new Dimension(600, 600));
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);
        CodeSnippetView view = new CodeSnippetView();
        screens.add(view);
        view.setVisible(true);
        application.setVisible(true);
    }
}