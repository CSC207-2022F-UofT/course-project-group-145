package chat;

import java.io.*;
import java.util.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class MessageRepository implements MessageRepoGateway{

    private final String filePath;

    private Map<Integer, MessageRepoRequestModel> messages = new HashMap<>();

    private int numMessages;

    public MessageRepository(String filePath) throws IOException {
        this.filePath = filePath;
        File JSONFile = new File(filePath);
        this.numMessages = 0;
        if (JSONFile.length() > 0) {
            FileReader reader = new FileReader(JSONFile);
            Gson gson = new GsonBuilder().create();
            messages = gson.fromJson(reader, new TypeToken<HashMap<Integer, MessageRepoRequestModel>>() {}.getType());
            reader.close();
            this.numMessages = messages.size();
        }
    }

    /**
     * Saves the message being sent to the JSON
     *
     * @param requestModel the request model containing the message being sent
     */
    @Override
    public void save(MessageRepoRequestModel requestModel) throws IOException {
        messages.put(requestModel.getMessageId(), requestModel);
        this.numMessages = this.numMessages + 1;
        saveJSON();
    }

    /**
     * Soft deleted the message by finding the message by id and setting its deleted variable to true
     *
     * @param messageId the request model created from controller with chat id and message
     */
    @Override
    public void delete(int messageId) throws IOException {
        MessageRepoRequestModel message = messages.remove(messageId);
        message.setDeleted(true);
        message.setLastEditTime(new Date());
        messages.put(messageId, message);
        saveJSON();
    }

    /**
     * Updates the message with specified message id to contain the new content
     *
     * @param messageId the id of the message being edited
     * @param content the updated content
     */
    @Override
    public void edit(int messageId, String content) throws IOException {
        MessageRepoRequestModel message = messages.remove(messageId);
        message.setEdited(true);
        message.setLastEditTime(new Date());
        message.setContent(content);
        messages.put(messageId, message);
        saveJSON();
    }

    /**
     * Saves the reply message to the JSON and update the message that is being replied to to contain the reply id
     *
     * @param reply the request model containing the message to be saved
     * @param replyToMessage the id of the message that the requestModel message is replying to
     */
    @Override
    public void addReply(MessageRepoRequestModel reply, int replyToMessage) throws IOException {
        MessageRepoRequestModel message = messages.remove(replyToMessage);
        message.setReplyId(reply.getMessageId());
        messages.put(replyToMessage, message);
        messages.put(reply.getMessageId(), reply);
        this.numMessages = this.numMessages + 1;
        saveJSON();
    }

    private void saveJSON() throws IOException {
        FileWriter writer = new FileWriter(filePath);
        Gson gson = new GsonBuilder().create();
        gson.toJson(messages, writer);
        writer.close();
    }


    /**
     * Returns the total number of messages in the repository
     *
     * @return the total number of messages
     */
    @Override
    public int getNumMessages(){
        return this.numMessages;
    }

    /**
     * Returns a list of messages that the specified input list needs
     *
     * @param messageIds the list of message ids of the messages that is needed
     * @return a list of MessageRepoRequestModel which are essentially messages
     */
    @Override
    public List<MessageRepoRequestModel> getMessages(List<Integer> messageIds) {
        List<MessageRepoRequestModel> messages = new ArrayList<>();
        for(Integer i: messageIds) {
            messages.add(this.messages.get(i));
        }
        return messages;
    }

    /**
     * Returns the map of all message ids to messages in the repository
     *
     * @return the map of all message ids to messages
     */
    @Override
    public Map<Integer, MessageRepoRequestModel> getAllMessages() {
        return this.messages;
    }
}
