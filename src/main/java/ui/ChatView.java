package ui;

import controller_presenter_gateway.chat_controller_presenter_gateway.ChatController;
import controller_presenter_gateway.chat_controller_presenter_gateway.ChatResponseModel;
import controller_presenter_gateway.chat_controller_presenter_gateway.MessageRepoRequestModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ChatView extends JPanel implements ChatViewInterface, ActionListener {

    private final JTextArea textArea = new JTextArea(5, 20);

    private ChatController controller;

    private final JPanel messages = new JPanel();

    private final JScrollPane scroll = new JScrollPane(messages, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private int chatId;

    private int userId;

    private int otherUser;

    private int numMessages = 0;

    /**
     *  The UI which is a JPanel of a chat between two users
     */
    public ChatView() {
        // will later pass in name of other person to put into title
        JLabel title = new JLabel("Chat");
        messages.setLayout(new BoxLayout(messages, BoxLayout.Y_AXIS));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel message = new JPanel();
        message.add(new JLabel("Message"));
        message.add(textArea);
        JButton send = new JButton("Send");
        JPanel buttons = new JPanel();
        buttons.add(send);
        send.addActionListener(this);
        send.setActionCommand("Send");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(scroll);
        this.add(message);
        this.add(buttons);
    }

    /**
     * React to button presses
     *
     * @param evt the event to be processed
     */
    public void actionPerformed(ActionEvent evt) {
        if (!textArea.getText().equals("") && evt.getActionCommand().equals("Send")) {
            this.controller.sendMessage(this.chatId, textArea.getText(), this.userId, this.otherUser);
            this.textArea.setText("");
            messages.revalidate();
            scroll.revalidate();
            this.revalidate();
        } else if(evt.getActionCommand().startsWith("Delete")){
            String[] s = evt.getActionCommand().split("\\s");
            int messageId = Integer.parseInt(s[1]);
            this.controller.deleteMessage(messageId);
            messages.revalidate();
            scroll.revalidate();
            this.revalidate();
        } else if(!textArea.getText().equals("") && evt.getActionCommand().startsWith("Reply")) {
            String[] s = evt.getActionCommand().split("\\s");
            int messageId = Integer.parseInt(s[1]);
            this.controller.replyMessage(this.chatId, textArea.getText(), this.userId, this.otherUser, messageId);
            this.textArea.setText("");
            messages.revalidate();
            scroll.revalidate();
            this.revalidate();
        } else if(!textArea.getText().equals("") && evt.getActionCommand().startsWith("Edit")) {
            String[] s = evt.getActionCommand().split("\\s");
            int messageId = Integer.parseInt(s[1]);
            this.controller.editMessage(messageId, textArea.getText());
            this.textArea.setText("");
            messages.revalidate();
            scroll.revalidate();
            this.revalidate();
        }
    }

    private void addMessages(List<MessageRepoRequestModel> messages) {
        List<Integer> list = new ArrayList<>();
        for(MessageRepoRequestModel message: messages) {
            if (!message.isDeleted() &&!list.contains(message.getMessageId())) {
                if (message.getReplyId() != -1) {
                    list.add(message.getReplyId());
                    addMessage(message.getMessageId(), message.getContent(), message.getAuthor(), true);
                    for(MessageRepoRequestModel m: messages) {
                        if(!m.isDeleted() && m.getMessageId() == message.getReplyId()){
                            addMessage(m.getMessageId(), m.getContent(), m.getAuthor(), m.getReplyId() != -1);
                        }
                    }
                } else {
                    addMessage(message.getMessageId(), message.getContent(), message.getAuthor(), false);
                }
            }
        }
    }


    private JPanel add(int messageId, String content, int author, boolean hasReply) {
        JPanel messageArea = new JPanel();
        JTextArea messageText = new JTextArea(content);
        messageArea.add(messageText);
        messageArea.add(new JLabel("from " + author));
        messageArea.setName(String.valueOf(messageId));
        messageText.setEditable(false);
        if (author != this.userId) {
            if (!hasReply) {
                JButton reply = new JButton("Reply");
                reply.addActionListener(this);
                reply.setActionCommand("Reply " + messageId);
                messageArea.add(reply);
            }
        } else {
            JButton delete = new JButton("Delete");
            delete.addActionListener(this);
            delete.setActionCommand("Delete " + messageId);
            messageArea.add(delete);

            JButton edit = new JButton("Edit");
            edit.addActionListener(this);
            edit.setActionCommand("Edit " + messageId);
            messageArea.add(edit);
        }
        return messageArea;
    }

    /**
     * Add a reply message directly under the message being replied to
     *
     * @param responseModel the reply message
     * @param replyToId the message being applied to
     */
    @Override
    public void addReply(ChatResponseModel responseModel, int replyToId){
        JPanel messageArea = add(responseModel.getMessageId(), responseModel.getContent(), responseModel.getAuthor(),
                false);
        Component[] components = messages.getComponents();
        for(int i = 0; i < components.length; i++){
            if(components[i].getName().equals(String.valueOf(replyToId))) {
                ((JPanel)components[i]).remove(2);
                messages.add(messageArea, i + 1);
            }
        }
        this.numMessages = this.numMessages + 1;
    }

    /**
     * Edit a message by directly changing the message to the String content in the correct message based on messageId
     *
     * @param messageId the message being edited
     * @param content the message content that the message is changing to
     */
    @Override
    public void editMessage(int messageId, String content) {
        Component[] components = messages.getComponents();
        for(Component c: components) {
            if(c.getName().equals(String.valueOf(messageId))){
                JTextArea messageText = new JTextArea(content);
                messageText.setEditable(false);
                ((JPanel)c).remove(0);
                ((JPanel)c).add(messageText,0);
            }
        }
    }

    /**
     * Add a message to the UI
     *
     * @param responseModel the given response model containing the message to be added
     */
    @Override
    public void addMessage(ChatResponseModel responseModel) {
        addMessage(responseModel.getMessageId(), responseModel.getContent(), responseModel.getAuthor(), false);
    }

    /**
     * Delete a message from the UI
     *
     * @param messageId the id of the message to be deleted
     */
    @Override
    public void deleteMessage(int messageId) {
        Component[] components = messages.getComponents();
        for(Component c: components) {
            if(c.getName().equals(String.valueOf(messageId))){
                messages.remove(c);
                this.numMessages = this.numMessages - 1;
            }
        }
    }

    private void addMessage(int messageId, String content, int author, boolean hasReply) {
        JPanel messageArea = add(messageId, content, author, hasReply);

        messages.add(messageArea, numMessages);
        numMessages += 1;
    }

    /**
     * Open a chat with given messages and ids
     *
     * @param chatId the id of the chat that is being opened
     * @param userId the id of the current user
     * @param otherUser the id of the other user of the chat
     */
    @Override
    public void openChat(int chatId, int userId, int otherUser, List<MessageRepoRequestModel> messages) {
        this.setUserId(userId);
        this.setOtherUser(otherUser);
        this.setChatId(chatId);
        this.setNumMessages(0);
        Component[] components = this.messages.getComponents();
        for(Component c: components) {
            this.messages.remove(c);
        }
        this.addMessages(messages);
        this.messages.revalidate();
        scroll.revalidate();
        this.revalidate();
        this.setVisible(true);

    }

    /**
     * Shows a message pane with error message
     *
     * @param message the error message
     */
    @Override
    public void failView(String message) {
        JOptionPane.showMessageDialog(this, message);
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
