package entities;

public class ActivityFactory {
    public Activity create(int userID) {
        return new Activity(userID);
    }
}
