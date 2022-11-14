package entities;

import java.util.Date;

public class Message {

    private static int numMessages = 0;

    private int messageId;

    private String content;

    private Date sendTime;

    private int author;

    private int receiver;

    private boolean isMessageSeen;

    private int replyId;

    private boolean isEdited;

    private boolean isDeleted;

    Message(String content, Date sendTime, int authorId, int receiverId) {
        this.messageId = numMessages;
        this.content = content;
        this.sendTime = sendTime;
        this.author = authorId;
        this.receiver = receiverId;
        this.isMessageSeen = false;
        this.isEdited = false;
        this.replyId = -1;              // initialize to an invalid id to indicate there is no reply
        this.isDeleted = false;
        numMessages = numMessages + 1;
    }

    public static int getNumMessages() {
        return numMessages;
    }

    public static void setNumMessages(int numMessages) {
        Message.numMessages = numMessages;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public boolean isMessageSeen() {
        return isMessageSeen;
    }

    public void setMessageSeen(boolean messageSeen) {
        isMessageSeen = messageSeen;
    }

    public boolean isEdited() {
        return isEdited;
    }

    public void setEdited(boolean edited) {
        isEdited = edited;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
