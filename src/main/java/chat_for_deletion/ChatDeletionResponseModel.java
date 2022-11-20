package chat_for_deletion;

import java.util.Date;

public class ChatDeletionResponseModel {
    private boolean isDeleted;

    public ChatDeletionResponseModel(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isDeleted() {return isDeleted;}

    public void setDeleted(boolean isDeleted) {this.isDeleted = isDeleted;}
}