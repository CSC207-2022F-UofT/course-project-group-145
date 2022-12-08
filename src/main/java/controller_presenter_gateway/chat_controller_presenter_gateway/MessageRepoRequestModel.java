package controller_presenter_gateway.chat_controller_presenter_gateway;

import java.util.Date;
/**
 * Request model for saving message information to the MessageRepository
 */
public class MessageRepoRequestModel {

    private int messageId;

    private String content;

    private final int author;

    private final int receiver;

    private final Date sendTime;

    private Date lastEditTime;

    private boolean isMessageSeen;

    private boolean isDeleted;

    private boolean isEdited;

    private int replyId;

    /**
     * Constructor for creating new MessageRepoRequestModel
     * @param messageId id of message to be saved
     * @param content content of message
     * @param author user id of author of message
     * @param receiver user id of recipient of message
     * @param sendTime send time of message
     * @param lastEditTime last edit time of message
     * @param isMessageSeen boolean flag if the receivever has seen message
     * @param isDeleted boolean flag if message has been deleted
     * @param isEdited flag if message is edited
     * @param replyId id of message this message replies to
     */
    public MessageRepoRequestModel(int messageId, String content, int author, int receiver, Date sendTime,
                                   Date lastEditTime, boolean isMessageSeen, boolean isDeleted, boolean isEdited,
                                   int replyId) {
        this.messageId = messageId;
        this.content = content;
        this.author = author;
        this.receiver = receiver;
        this.sendTime = sendTime;
        this.lastEditTime = lastEditTime;
        this.isMessageSeen = isMessageSeen;
        this.isDeleted = isDeleted;
        this.isEdited = isEdited;
        this.replyId = replyId;
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

    public int getAuthor() {
        return author;
    }

    public int getReceiver() {
        return receiver;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public boolean isMessageSeen() {
        return isMessageSeen;
    }

    public void setMessageSeen(boolean messageSeen) {
        isMessageSeen = messageSeen;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
