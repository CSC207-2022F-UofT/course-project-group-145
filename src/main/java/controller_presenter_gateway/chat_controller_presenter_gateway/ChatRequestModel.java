package controller_presenter_gateway.chat_controller_presenter_gateway;

import java.util.Date;

public class ChatRequestModel {

    private int chatId;

    private String content;

    private int author;

    private int receiver;

    private Date sendTime;

    public ChatRequestModel(int chatId, String content, int author, int receiver, Date sendTime) {
        this.chatId = chatId;
        this.content = content;
        this.author = author;
        this.receiver = receiver;
        this.sendTime = sendTime;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
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

    public int getReceiver() {
        return receiver;
    }

    public Date getSendTime() {
        return sendTime;
    }
}
