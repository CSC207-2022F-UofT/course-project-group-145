package controller_presenter_gateway.chat_controller_presenter_gateway;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ChatRepository that keeps track of all chats along with saving to the JSON file given by filePath
 */
public class ChatRepository implements ChatRepoGateway {

    private final String filePath;

    private Map<Integer, ChatRepoRequestModel> chats = new HashMap<>();

    private int numChats;

    /**
     * Create a ChatRepository that keeps track of all chats along with saving to the JSON file given by filePath
     *
     * @param filePath the file path of the JSON file
     * @throws IOException if the file does not contain the correct format
     */
    public ChatRepository(String filePath) throws IOException {
        this.filePath = filePath;
        File JSONFile = new File(filePath);
        this.numChats = 0;
        if (JSONFile.length() > 0) {
            FileReader reader = new FileReader(JSONFile);
            Gson gson = new GsonBuilder().create();
            chats = gson.fromJson(reader, new TypeToken<HashMap<Integer, ChatRepoRequestModel>>() {}.getType());
            reader.close();
            this.numChats = chats.size();
        }
    }

    /**
     * Deletes the chat by changing is_deleted to true (even if already deleted).
     * Then saves to the JSON file.
     *
     * @param chatId the id of the chat that is being deleted
     */
    @Override
    public void delete(int chatId) throws IOException {
        ChatRepoRequestModel chat = chats.remove(chatId);
        chat.setDeleted(true);
        chats.put(chatId, chat);
        saveJSON();
    }

    /**
     * Returns the total number of chats in the repository
     *
     * @return the total number of chats
     */
    @Override
    public int getNumChats(){
        return numChats;
    }

    /**
     * Updates the map of id to chats with the specified chatId adding a new messageId to their list of messageIds
     * It is then saved to the JSON file
     *
     * @param chatId the id of the chat that is adding a message
     * @param messageId the id of the message that is being added
     */
    @Override
    public void addMessage(int chatId, int messageId) throws IOException {
        ChatRepoRequestModel chat = chats.remove(chatId);
        List<Integer> messageIds = chat.getMessageIds();
        messageIds.add(messageId);
        chat.setMessageIds(messageIds);
        chats.put(chatId, chat);
        saveJSON();
    }

    /**
     * Saves the chat being created to the JSON
     *
     * @param requestModel the request model containing the chat being created
     */
    @Override
    public void save(ChatRepoRequestModel requestModel) throws IOException {
        chats.put(requestModel.getChatId(), requestModel);
        this.numChats = this.numChats + 1;
        saveJSON();
    }

    private void saveJSON() throws IOException {
        FileWriter writer = new FileWriter(filePath);
        Gson gson = new GsonBuilder().create();
        gson.toJson(chats, writer);
        writer.close();
    }

    /**
     * Returns the map of all chat ids to chats in repository
     *
     * @return the map of all chat ids to chats
     */
    @Override
    public Map<Integer, ChatRepoRequestModel> getAllChats() {
        return this.chats;
    }

    /**
     * Get the list of message ids of the given chat id
     *
     * @param chatId the chat id
     * @return the list of message ids of the given chat id
     */
    @Override
    public List<Integer> getMessagesOfChat(int chatId) {
        ChatRepoRequestModel chat = this.chats.get(chatId);
        return chat.getMessageIds();
    }
}
