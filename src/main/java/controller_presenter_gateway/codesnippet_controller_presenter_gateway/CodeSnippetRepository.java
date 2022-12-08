package controller_presenter_gateway.codesnippet_controller_presenter_gateway;

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
import java.util.stream.Collectors;

/**
 * Repository that stores code snippet information in persistent as a JSON
 */
public class CodeSnippetRepository implements CodeSnippetRepoGateway {
    private final String filePath;

    private Map<Integer, CodeSnippetResponseModel> codeSnippets = new HashMap<>();
    private int numCodeSnippets;

    /**
     * Constructor that initialises a new CodeSnippetRepository
     * @param filePath file path to the storage file
     * @throws IOException if file reader does not read properly when initialising the repo
     */
    public CodeSnippetRepository(String filePath) throws IOException {
        this.filePath = filePath;

        File JSONFile = new File(filePath);
        if (JSONFile.length() > 0) {
            FileReader reader = new FileReader(JSONFile);
            Gson gson = new GsonBuilder().create();
            codeSnippets = gson.fromJson(reader, new TypeToken<HashMap<Integer, CodeSnippetResponseModel>>() {}.getType());
            reader.close();
            this.numCodeSnippets = codeSnippets.size();
        }
    }

    private void saveJSON() throws IOException {
        FileWriter writer = new FileWriter(filePath);
        Gson gson = new GsonBuilder().create();
        gson.toJson(codeSnippets, writer);
        writer.close();
    }

    /**
     * Returns the number of code snippets
     * @return the number of code snippets currently saved
     */
    @Override
    public int getNumCodeSnippets() {
        return numCodeSnippets;
    }

    /**
     * Save a code snippet to persistent based on the data in CodeSnippetResponseModel
     * @param responseModel model containing info about snippet
     * @throws IOException returned if there's an error in saving to json file
     */
    @Override
    public void save(CodeSnippetResponseModel responseModel) throws IOException {
        codeSnippets.put(responseModel.getId(), responseModel);
        this.numCodeSnippets = this.numCodeSnippets + 1;
        saveJSON();
    }

    /**
     * Deletes the snippet by changing is_deleted to true (even if already deleted).
     * Then saves to the JSON file.
     *
     * @param codeSnippetId the id of the chat that is being deleted
     */
    @Override
    public void delete(int codeSnippetId) throws IOException {
        CodeSnippetResponseModel codeSnippet = codeSnippets.remove(codeSnippetId);
        codeSnippet.setIsDeleted();
        codeSnippets.put(codeSnippetId, codeSnippet);
        saveJSON();
    }

    /**
     * Retrieves the code snippet from persistence
     * @param codeSnippetId id of snippet to retrieve
     * @return CodeSnippetResponseModel containing info of the snippet
     */
    @Override
    public CodeSnippetResponseModel retrieve(int codeSnippetId) {
        return this.codeSnippets.get(codeSnippetId);
    }

    /**
     * Returns all code snippets
     * @return A map of code snippet ID to their information in a response model
     */
    @Override
    public Map<Integer, CodeSnippetResponseModel> getAllCodeSnippets() {
        return this.codeSnippets;
    }

    /**
     * Returns all code snippets from a user
     * @param userId id of user
     * @return A map of code snippet ID to their information in a response model
     */
    @Override
    public List<CodeSnippetResponseModel> getCodeSnippetsByUserId(int userId) {
        return this.codeSnippets.values().stream().filter(x -> x.getUserId() == userId)
                .collect(Collectors.toList());
    }
}
