package entities;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

class Activity {
    private int userId;
    private List<Action> actions;

    Activity(int userId) {
        this.userId = userId;
        this.actions = new ArrayList<Action>();
    }

    /**
     * Gets the user id of the User object.
     *
     * @return user id.
     */
    public int getUserId() {return userId;}

    /**
     * Sets the user id of the User object.
     *
     * @param userId is the user id of the User object.
     */
    public void setUserId(int userId) {this.userId = userId;}

    /**
     * Adds an action that has occurred.
     *
     * @param action is the action to be added.
     */
    public void addAction(Action action) {
        actions.add(action);
    }

    /**
     * Returns true if an action exists, false if not.
     *
     * @param referenceId is the reference id of the action to be checked.
     * @return boolean to be returned.
     */
    public boolean existsAction(int referenceId) {
        for (Action a : actions) {
            if (a.getReferenceID() == referenceId) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets an action by reference id.
     *
     * @param referenceId is the reference id of an action.
     * @return the action.
     * @throws IOException in case the action cannot be returned.
     */
    public Action getAction (int referenceId) throws IOException{
        for (Action a : actions) {
            if(a.getReferenceID() == referenceId) {
                return a;
            }
        }
        throw new IOException();
    }
}
