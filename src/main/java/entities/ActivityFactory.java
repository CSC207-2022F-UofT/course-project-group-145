package entities;

/**
 * Factory for creating Activity entities
 */
public class ActivityFactory {
    public Activity create(int userID) {
        return new Activity(userID);
    }
}
