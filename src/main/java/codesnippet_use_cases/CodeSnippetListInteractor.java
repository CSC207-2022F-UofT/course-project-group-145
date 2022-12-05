package codesnippet_use_cases;

import codesnippet.CodeSnippetRepoGateway;
import codesnippet.CodeSnippetRequestModel;
import codesnippet.CodeSnippetResponseModel;
import codesnippet_presenter.CodeSnippetOutputBoundary;
import entities.CodeSnippet;
import entities.CodeSnippetFactory;

import java.io.IOException;
import java.util.Date;

public class CodeSnippetListInteractor implements CodeSnippetListInputBoundary {

    final CodeSnippetRepoGateway codeSnippetGateway;
    final CodeSnippetOutputBoundary codeSnippetOutputBoundary;
    final CodeSnippetFactory codeSnippetFactory;

    public CodeSnippetListInteractor(CodeSnippetFactory codeSnippetFactory, CodeSnippetRepoGateway codeSnippetGateway, CodeSnippetOutputBoundary codeSnippetOutputBoundary) {
        this.codeSnippetFactory = codeSnippetFactory;
        this.codeSnippetGateway = codeSnippetGateway;
        this.codeSnippetOutputBoundary = codeSnippetOutputBoundary;
    }

    @Override
    public CodeSnippetResponseModel create(CodeSnippetRequestModel requestModel) throws IOException {
        int nextId = codeSnippetGateway.getNumCodeSnippets() + 1;
        CodeSnippet codeSnippet = codeSnippetFactory.create(nextId, requestModel.getUserId(), requestModel.getTitle(), requestModel.getFileUrl(), requestModel.getCreationTime());

        CodeSnippetResponseModel codeSnippetModel = new CodeSnippetResponseModel(nextId, codeSnippet.getUserId(), codeSnippet.getTitle(), codeSnippet.getFileUrl(), new Date());
        codeSnippetGateway.save(codeSnippetModel);

        CodeSnippetResponseModel codeSnippetResponseModel = new CodeSnippetResponseModel(codeSnippet.getId(), codeSnippet.getUserId(), codeSnippet.getTitle(), codeSnippet.getFileUrl(),  codeSnippet.getCreationTime());
        return codeSnippetResponseModel;
    }

    @Override
    public CodeSnippetResponseModel upload(CodeSnippetRequestModel requestModel) {
        return null;
    }

    @Override
    public CodeSnippetResponseModel edit(int codeSnippetId, CodeSnippetResponseModel content) {
        return null;
    }

    @Override
    public void delete(int codeSnippetId) {
//        codeSnippetGateway.delete(codeSnippetId);
        codeSnippetOutputBoundary.delete(codeSnippetId);
    }
}
