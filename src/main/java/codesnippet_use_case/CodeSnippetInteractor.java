package codesnippet_use_case;

import codesnippet.CodeSnippetFactory;
import codesnippet.CodeSnippetRepoGateway;
import codesnippet.CodeSnippetRequestModel;
import codesnippet.CodeSnippetResponseModel;
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
        int nextId = codeSnippetGateway.getNumCodeSnippets() + 1;
        CodeSnippet codeSnippet = codeSnippetFactory.create(nextId, requestModel.getTitle(), requestModel.getUserId(), requestModel.getFileUrl());

        LocalDateTime now = LocalDateTime.now();
        CodeSnippetRequestModel codeSnippetModel = new CodeSnippetRequestModel(codeSnippet.getId(), codeSnippet.getTitle(), codeSnippet.getUserId(), codeSnippet.getFileUrl(), now);
        codeSnippetGateway.save(codeSnippetModel);

        CodeSnippetResponseModel codeSnippetResponseModel = new CodeSnippetResponseModel(codeSnippet.getTitle(), codeSnippet.getFileUrl(), now.toString());
        return codeSnippetResponseModel;
    }
}