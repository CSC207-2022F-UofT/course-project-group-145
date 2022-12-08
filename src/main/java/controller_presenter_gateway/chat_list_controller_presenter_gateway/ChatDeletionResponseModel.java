package controller_presenter_gateway.chat_list_controller_presenter_gateway;

import java.util.Date;

/**
 * Response model passed by ChatDeletionUseCase to ChatListPresenter
 */
public class ChatDeletionResponseModel {
    private boolean isDeleted;

    /**
     * constructor for creating a ChatDeletionResponseModel
     * @param isDeleted flag on whether the chat is deleted
     */
    public ChatDeletionResponseModel(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isDeleted() {return isDeleted;}

    public void setDeleted(boolean isDeleted) {this.isDeleted = isDeleted;}
}