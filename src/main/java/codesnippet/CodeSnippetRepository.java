package codesnippet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.CodeSnippet;
import entities.CodeSnippetFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeSnippetRepository implements CodeSnippetRepoGateway {
    private final String filePath;

    private Map<Integer, CodeSnippetRequestModel> codeSnippets = new HashMap<>();
    private int numCodeSnippets;

    public CodeSnippetRepository(String filePath) throws IOException {
        this.filePath = filePath;

        File JSONFile = new File(filePath);
        if (JSONFile.length() > 0) {
            FileReader reader = new FileReader(JSONFile);
            Gson gson = new GsonBuilder().create();
            codeSnippets = gson.fromJson(reader, new TypeToken<List<CodeSnippet>>() {}.getType());
            reader.close();
            this.numCodeSnippets = codeSnippets.size();
        }
    }

    @Override
    public void save(CodeSnippetRequestModel requestModel) throws IOException {
        codeSnippets.put(requestModel.getCodeSnippetId(), requestModel);
        this.numCodeSnippets = numCodeSnippets + 1;
        saveJSON();
    }

    private void saveJSON() throws IOException {
        FileWriter writer = new FileWriter(filePath);
        Gson gson = new GsonBuilder().create();
        gson.toJson(codeSnippets, writer);
        writer.close();
    }

    @Override
    public CodeSnippetResponseModel retrieve(int codeSnippetId) throws IOException {
        return null;
    }

    @Override
    public List<CodeSnippetResponseModel> getCodeSnippets(List<Integer> codeSnippetIds) throws IOException {
        return null;
    }

    @Override
    public Map<Integer, CodeSnippetResponseModel> getAllCodeSnippets() throws IOException {
        return null;
    }
}
