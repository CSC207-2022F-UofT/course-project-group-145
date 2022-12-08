package controller_presenter_gateway.chat_controller_presenter_gateway;

import java.util.Date;
/**
 * Response model used to send information to the ChatPresenter
 */
public class ChatResponseModel {

    private int messageId;

    private String content;

    private int author;

    private int receiver;

    private Date sendTime;

    /**
     * Creates a new ChatReponseModel used to send information to the ChatPresenter
     * @param messageId id of the message being sent
     * @param content content of the message being sent
     * @param author user id of sender
     * @param receiver user id of receiver
     * @param sendTime send time of message
     */
    public ChatResponseModel(int messageId, String content, int author, int receiver, Date sendTime) {
        this.messageId = messageId;
        this.content = content;
        this.author = author;
        this.receiver = receiver;
        this.sendTime = sendTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
}
