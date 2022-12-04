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

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public void addAction(Action action) {
        actions.add(action);
    }

    public boolean existsAction(int referenceId) {
        for (Action a : actions) {
            if (a.getReferenceID() == referenceId) {
                return true;
            }
        }
        return false;
    }

    public Action getAction (int referenceId) throws IOException{
        for (Action a : actions) {
            if(a.getReferenceID() == referenceId) {
                return a;
            }
        }
        throw new IOException();
    }
}
