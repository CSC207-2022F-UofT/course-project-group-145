package ui;

import controller_presenter_gateway.user_controller_presenter_gateway.LoginController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Java swing ui that allows the user to log in with their username and password
 */
public class LoginView extends JPanel implements ActionListener, LoginViewInterface {

    private LoginController controller;

    JTextField textField1;
    JTextField textField2;


    /**
     * initialises a new login view
     */
    public LoginView() {
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


        this.textField1 = new JTextField();
        textField1.setBounds(170, 100, 200, 20);
        this.add(textField1);

        this.textField2 = new JTextField();
        textField2.setBounds(170, 150, 200, 20);
        this.add(textField2);

        JButton submit = new JButton("Submit");
        submit.setBounds(200, 250, 100, 20);
        submit.addActionListener(this);
        submit.setActionCommand("Submit");
        this.add(submit);

        JButton register = new JButton("Register Here");
        register.setBounds(200, 450, 100, 20);
        register.addActionListener(this);
        register.setActionCommand("Register");
        this.add(register);


        this.setSize(500, 500);

        this.setVisible(true);

    }

    /**
     * Method called by the elements of this UI whenever a user performs an action
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Submit")){
            this.controller.login(textField1.getText(), textField2.getText());
            this.setVisible(false);
        } else if (e.getActionCommand().equals("Register")) {
            this.controller.openRegister();
            this.setVisible(false);
        }

    }


    public void setController(LoginController controller) {
        this.controller = controller;
    }

    /**
     * Makes this screen visible
     */
    @Override
    public void open(){
        this.setVisible(true);
    }
}
