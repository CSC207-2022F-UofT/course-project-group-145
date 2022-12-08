package entities;

/**
 * Factory for creating Action entities
 */
public class ActionFactory {

    public Action create(int userId, ActionType actionType, int doneOnUserId, int referenceID) {
        return new Action(userId, actionType, doneOnUserId, referenceID);
    }
}
