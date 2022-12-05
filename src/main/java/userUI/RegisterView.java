package userUI;

import user.UserController;
import user.UserResponseModel;
import user.UserRepoRequestModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class RegisterView extends JPanel implements RegisterViewInterface, ActionListener{

    private UserController controller;

    private static int numUsers = 0;

    private int userId;

    private String username;

    private String password;

    private String email;

    private boolean isDeleted;

    private int width;
    private int height;

    private Map<Integer, Integer> mapOfChatToOtherUser;

    private List<Integer> listOfFeedIds;

    JButton submit;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;



    public RegisterView() {
        setLayout(null);

        JLabel Title = new JLabel("Please Enter The Following Information:");
        Title.setBounds(100, 50, 400, 20);
        this.add(Title);

        JLabel username = new JLabel("Username");
        username.setBounds(100, 100, 100, 20);
        this.add(username);

        JLabel password = new JLabel("Password");
        password.setBounds(100, 150, 100, 20);
        this.add(password);

        JLabel email = new JLabel("Email");
        email.setBounds(100, 200, 100, 20);
        this.add(email);

        JTextField textField1 = new JTextField();
        textField1.setBounds(170, 100, 200, 20);
        this.add(textField1);

        JTextField textField2 = new JTextField();
        textField2.setBounds(170, 150, 200, 20);
        this.add(textField2);

        JTextField textField3 = new JTextField();
        textField3.setBounds(170, 200, 200, 20);
        this.add(textField3);

        JButton submit = new JButton("Submit");
        submit.setBounds(200, 250, 100, 20);
        submit.addActionListener(this);
        this.add(submit);

        this.setSize(500, 500);

        this.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        try {
            this.controller.saveUser(textField1.getText(), textField2.getText(), textField3.getText(),
                    new HashMap<>(), new ArrayList<>());
            this.setVisible(false);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }


    public void setController(UserController controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        RegisterView view = new RegisterView();
        JFrame app = new JFrame();
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);

        app.add(screens);

        screens.add(view);

        app.pack();
        app.setVisible(true);

    }

}
