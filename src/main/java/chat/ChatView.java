package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class ChatView extends JPanel implements ChatViewInterface, ActionListener {

    private JTextArea textArea = new JTextArea(5, 20);

    private ChatController controller;

    private int chatId;

    private int userId;

    private int otherUser;

    private int numMessages = 0;

    public ChatView() {
        // will later pass in name of other person to put into title
        JLabel title = new JLabel("Chat");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel message = new JPanel();
        message.add(new JLabel("Message"));
        message.add(textArea);
        JButton send = new JButton("Send");
        JPanel buttons = new JPanel();
        buttons.add(send);
        send.addActionListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        //this.add(new JScrollBar());
        this.add(message);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
        try {
            if (!textArea.getText().equals("")) {
                this.controller.sendMessage(this.chatId, textArea.getText(), this.userId, this.otherUser);
                this.revalidate();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addMessages(List<MessageRepoRequestModel> messages) {
        for(MessageRepoRequestModel message: messages) {
            addMessage(message.getContent(), message.getAuthor());
        }
    }

    @Override
    public void addMessage(ChatResponseModel responseModel) {
        addMessage(responseModel.getContent(), responseModel.getAuthor());
    }

    private void addMessage(String content, int author) {
        JPanel messageArea = new JPanel();
        JTextArea messageText = new JTextArea(content);
        messageArea.add(messageText);
        messageArea.add(new JLabel("from " + author));
        messageText.setEditable(false);

        this.add(messageArea, numMessages + 1);
        numMessages += 1;
    }

    public void setController(ChatController controller) {
        this.controller = controller;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setOtherUser(int otherUser) {
        this.otherUser = otherUser;
    }

    public void setNumMessages(int numMessages) {
        this.numMessages = numMessages;
    }
}
