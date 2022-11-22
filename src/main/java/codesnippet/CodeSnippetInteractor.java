package codesnippet;

import entities.CodeSnippet;

import java.io.IOException;
import java.time.LocalDateTime;

public class CodeSnippetInteractor implements CodeSnippetInputBoundary {

    final CodeSnippetRepoGateway codeSnippetGateway;
    final CodeSnippetFactory codeSnippetFactory;

    public CodeSnippetInteractor(CodeSnippetRepoGateway codeSnippetGateway, CodeSnippetFactory codeSnippetFactory) {
        this.codeSnippetGateway = codeSnippetGateway;
        this.codeSnippetFactory = codeSnippetFactory;
    }

    @Override
    public CodeSnippetResponseModel create(CodeSnippetRequestModel requestModel) throws IOException {

        CodeSnippet codeSnippet = codeSnippetFactory.create(requestModel.getTitle(), requestModel.getUserId(), requestModel.getFileUrl());

        LocalDateTime now = LocalDateTime.now();
        CodeSnippetRequestModel codeSnippetModel = new CodeSnippetRequestModel(codeSnippet.getTitle(), codeSnippet.getUserId(), codeSnippet.getFileUrl(), now);
        codeSnippetGateway.save(codeSnippetModel);

        CodeSnippetResponseModel codeSnippetResponseModel = new CodeSnippetResponseModel(codeSnippet.getTitle(), codeSnippet.getFileUrl(), now.toString());
        return codeSnippetResponseModel;
    }

    @Override
    public CodeSnippetResponseModel update(int codeSnippetId, CodeSnippetRequestModel requestModel) throws IOException {
        return null;
    }

    @Override
    public void delete(int codeSnippetId) throws IOException {

    }
}
