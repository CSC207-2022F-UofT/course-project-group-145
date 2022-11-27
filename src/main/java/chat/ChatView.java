package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatView extends JPanel implements ChatViewInterface, ActionListener {

    private final JTextArea textArea = new JTextArea(5, 20);

    private ChatController controller;

    private JPanel messages = new JPanel();

    private JScrollPane scroll = new JScrollPane(messages, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private int chatId;

    private int userId;

    private int otherUser;

    private int numMessages = 0;

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

    public void actionPerformed(ActionEvent evt) {
        try {
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

            } else if(evt.getActionCommand().startsWith("Edit")) {

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void addMessages(List<MessageRepoRequestModel> messages) {
        List<Integer> list = new ArrayList<>();
        for(MessageRepoRequestModel message: messages) {
            if (!message.isDeleted() &&!list.contains(message.getMessageId())) {
                if (message.getReplyId() != -1) {
                    list.add(message.getReplyId());
                    addMessage(message.getMessageId(), message.getContent(), message.getAuthor(), true);
                    for(MessageRepoRequestModel m: messages) {
                        if(!m.isDeleted() && m.getMessageId() == message.getReplyId()){
                            if(m.getReplyId() != -1) {
                                addMessage(m.getMessageId(), m.getContent(), m.getAuthor(), true);
                            } else {
                                addMessage(m.getMessageId(), m.getContent(), m.getAuthor(), false);
                            }
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
        if (author != this.userId) {
            messageText.setEditable(false);
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

    @Override
    public void addReply(ChatResponseModel responseModel, int replyToId){
        JPanel messageArea = add(responseModel.getMessageId(), responseModel.getContent(), responseModel.getAuthor(),
                false);
        Component[] components = messages.getComponents();
        for(int i = 0; i < components.length; i++){
            if(components[i].getName().equals(String.valueOf(replyToId))) {
                messages.add(messageArea, i + 1);
            }
        }
        this.numMessages = this.numMessages + 1;
    }

    @Override
    public void addMessage(ChatResponseModel responseModel) {
        addMessage(responseModel.getMessageId(), responseModel.getContent(), responseModel.getAuthor(), false);
    }

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

    @Override
    public void openChat(int chatId, int userId, int otherUser, List<MessageRepoRequestModel> messages) {
        this.setUserId(userId);
        this.setOtherUser(otherUser);
        this.setChatId(chatId);
        this.setNumMessages(0);
        this.addMessages(messages);
        this.setVisible(true);

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
