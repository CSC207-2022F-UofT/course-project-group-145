package ui;

import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetListViewController;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

    public class CodeSnippetView extends JPanel implements CodeSnippetViewInterface, ActionListener {
        static private final String newline = "\n";
        private int userId;
        private CodeSnippetViewController viewController;
        private CodeSnippetListViewController listController;
        JButton uploadButton;

        JTextArea log;

        JFileChooser fc;

        public CodeSnippetView() {
            super(new BorderLayout());

            //Create the log first, because the action listeners
            //need to refer to it.
            log = new JTextArea(5, 20);
            log.setMargin(new Insets(5, 5, 5, 5));
            log.setEditable(false);
            JScrollPane logScrollPane = new JScrollPane(log);

            //Create a file chooser
            fc = new JFileChooser();

            uploadButton = new JButton("Upload a Code Snippet...",
                    createImageIcon("images/Open16.gif"));
            uploadButton.addActionListener(this);

            //For layout purposes, put the buttons in a separate panel
            JPanel buttonPanel = new JPanel(); //use FlowLayout
            buttonPanel.add(uploadButton);

            //Add the buttons and the log to this panel.
            add(buttonPanel, BorderLayout.PAGE_START);
            add(logScrollPane, BorderLayout.CENTER);
        }

        public void actionPerformed(ActionEvent e) {
            //Handle upload button action.
            if (e.getSource() == uploadButton) {
                int returnVal = fc.showOpenDialog(CodeSnippetView.this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    log.append("Uploading: " + file.getName() + "." + newline);
                    this.listController.uploadCodeSnippet(userId, file.getName(), file.getPath());
                } else {
                    log.append("Upload command cancelled by user." + newline);
                }
                log.setCaretPosition(log.getDocument().getLength());
            }
        }

        /** Returns an ImageIcon, or null if the path was invalid. */
        protected static ImageIcon createImageIcon(String path) {
            java.net.URL imgURL = CodeSnippetView.class.getResource(path);
            if (imgURL != null) {
                return new ImageIcon(imgURL);
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
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