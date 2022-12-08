package use_cases.codesnippet_use_cases;

import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetRepoGateway;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetRequestModel;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetResponseModel;
import controller_presenter_gateway.codesnippet_controller_presenter_gateway.CodeSnippetOutputBoundary;
import entities.CodeSnippet;
import entities.CodeSnippetFactory;

import java.io.IOException;
import java.util.Date;

/**
 * Use case interactor for uploading a code snippet
 */
public class CodeSnippetListInteractor implements CodeSnippetListInputBoundary {

    final CodeSnippetRepoGateway codeSnippetGateway;
    final CodeSnippetOutputBoundary codeSnippetOutputBoundary;
    final CodeSnippetFactory codeSnippetFactory;

    /**
     * Creates a new instance
     * @param codeSnippetFactory factory for creating code snippets
     * @param codeSnippetGateway repository for storing code snippets
     * @param codeSnippetOutputBoundary presenter for updating with info
     */
    public CodeSnippetListInteractor(CodeSnippetFactory codeSnippetFactory, CodeSnippetRepoGateway codeSnippetGateway, CodeSnippetOutputBoundary codeSnippetOutputBoundary) {
        this.codeSnippetFactory = codeSnippetFactory;
        this.codeSnippetGateway = codeSnippetGateway;
        this.codeSnippetOutputBoundary = codeSnippetOutputBoundary;
    }

    /**
     * Uploads a new code snippet and saves it to the persistence
     * @param requestModel request model containing all relevant information about the snippet
     * @return a response model containing information about the snippet
     * @throws IOException
     */
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

    /**
     * Deletes a code snippet from the persistence
     * @param codeSnippetId
     */
    @Override
    public void delete(int codeSnippetId) {
//        codeSnippetGateway.delete(codeSnippetId);
        codeSnippetOutputBoundary.delete(codeSnippetId);
    }
}
