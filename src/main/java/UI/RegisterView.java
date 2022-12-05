package ui;

import controller_presenter_gateway.user_controller_presenter_gateway.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

public class RegisterView extends JPanel implements RegisterViewInterface, ActionListener{

    private UserController controller;

    private static int numUsers = 0;
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

        this.textField1 = new JTextField();
        textField1.setBounds(170, 100, 200, 20);
        this.add(textField1);

        this.textField2 = new JTextField();
        textField2.setBounds(170, 150, 200, 20);
        this.add(textField2);

        this.textField3 = new JTextField();
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


    @Override
    public void open() {
        this.setVisible(true);
    }

}
