package chat_for_deletion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ChatDeletionRepo implements ChatDeletionGateway {

    private final File JSONFile;
    private String filePath;
    private Map<Integer, ChatDeletionRepoReqModel> chats = new HashMap<>();

    public ChatDeletionRepo(String filePath) throws IOException {
        this.filePath = filePath;
        JSONFile = new File(filePath);
        if (JSONFile.length() > 0) {
            FileReader reader = new FileReader(JSONFile);
            Gson gson = new GsonBuilder().create();
            chats = gson.fromJson(reader, new TypeToken<HashMap<Integer, ChatDeletionRepoReqModel>>() {}.getType());
            reader.close();
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
        ChatDeletionRepoReqModel chat = chats.remove(chatId);
        chat.setDeleted(true);
        chats.put(chatId, chat);
        saveJSON();
     }

    /**
     * Saves the chat being created to the JSON
     *
     * @param requestModel the request model containing the chat being created
     */
    @Override
    public void save(ChatDeletionRepoReqModel requestModel) throws IOException {
        chats.put(requestModel.getChatId(), requestModel);
        saveJSON();
    }

    private void saveJSON() throws IOException {
        FileWriter writer = new FileWriter(filePath);
        Gson gson = new GsonBuilder().create();
        gson.toJson(chats, writer);
        writer.close();
    }
}