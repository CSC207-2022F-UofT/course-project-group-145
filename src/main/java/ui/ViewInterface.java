package ui;

/**
 * Interface that can be used for views to observe view models (since Observer is deprecated)
 * To use, have view implement this class, then have view model call update from this interface.
 * to report fail case, have your view model call the reportFail method with an error message.
 */
public interface ViewInterface {

    void update();

    void reportFail(String errMsg);
}
