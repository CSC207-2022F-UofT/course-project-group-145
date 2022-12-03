package entities;

import java.util.Date;

enum ActionType {SWIPE, VIEWPROFILE, MATCH}

public class Action {
    //can make these final, since they don't need to be changed
    private int userId;
    private int doneOnUserId;
    private ActionType actionType;
    private int referenceID;
    private Date doneAt;

    // swipes,
    Action (int userId, ActionType actionType, int doneOnUserId, int referenceID) {
        this.userId = userId;
        this.actionType = actionType;
        this.doneOnUserId = doneOnUserId;
        this.referenceID = referenceID;
        this.doneAt = new Date();
    }

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public ActionType getActionType() {return actionType;}

    public void setActionType(ActionType actionType) {this.actionType = actionType;}

    public int getReferenceID() {return referenceID;}

    public void setReferenceID(int referenceID) {this.referenceID = referenceID;}

    public Date getDoneAt() {return doneAt;}

    public void setDoneAt(Date doneAt) {this.doneAt = doneAt;}

    public int getDoneOnUserId() {return doneOnUserId;}

    public void setDoneOnUserId(int doneOnUserId) {this.doneOnUserId = doneOnUserId;}
}
